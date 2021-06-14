package com.example.appthoitiet.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthoitiet.Adapter.AdapterContact;
import com.example.appthoitiet.Adapter.AdapterContect6time;
import com.example.appthoitiet.Model.Contect;
import com.example.appthoitiet.DBManage.DBHistory;
import com.example.appthoitiet.DBManage.DBsetting;
import com.example.appthoitiet.Model.setting;
import com.example.appthoitiet.R;
import com.example.appthoitiet.ConvertJson.Json;
import com.example.appthoitiet.Model.Weather;
import com.example.appthoitiet.ConvertJson.trangthaithoitiet;
import com.example.appthoitiet.Model.history;
import com.github.mikephil.charting.charts.CombinedChart;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    // khai báo
    ImageView Imvsearch, Imv_icon_weather, Imv_icon_map, Imv_icon_setting, Imvdof;
    RecyclerView recyclerView, recyclerView6time;
    AdapterContact adapterContact;
    AdapterContect6time adapterContect6time;
    RelativeLayout Relenter;
    EditText editText;
    LinearLayout linearLayout, baonhapvao;
    TextView textView, Tvtemperature, Tvday, Tvplace, Tvwind, Tvweather, tvLocation, Tvdoam, Tvgioview, Tvthu;

    // khai báo list tt thời tiết
    List<Contect> contacts = new ArrayList<>();

    List<Contect> contacts6time = new ArrayList<>();

// cài đặt setting trước
    setting settingsql = new setting(2, 2, 3, 1);

    //
    CombinedChart mChart;
    Json JSON = new Json();
    Weather weathertt = new Weather();
    Weather weathertt1 = new Weather();
    private int searh = 0;

    private history historyMa;
    DBHistory dbHistory = new DBHistory(this);
    DBsetting dBsetting = new DBsetting(this);
    trangthaithoitiet ttthoitiet = new trangthaithoitiet();
    private Location location;
    // Đối tượng tương tác với Google API
    private GoogleApiClient gac;
    // Hiển thị vị trí
    private double latitude = 0;
    private double longitude = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Imv_icon_map = findViewById(R.id.map);
        Imv_icon_weather = findViewById(R.id.iconweather);
        Imvdof = findViewById(R.id.Imvdof);
        Relenter = findViewById(R.id.Rlaenter);
        tvLocation = findViewById(R.id.tvLocation);
        Imv_icon_setting = findViewById(R.id.setting);
        baonhapvao = findViewById(R.id.baonhapvao);
        linearLayout = findViewById(R.id.backgrow);
        Imvsearch = findViewById(R.id.Imvsearch);
        editText = findViewById(R.id.nhapvao);
        editText.setVisibility(View.GONE);
        textView = findViewById(R.id.timeofday);
        Tvplace = findViewById(R.id.Tvplace);
        Tvtemperature = findViewById(R.id.Tvtemperature);
        Tvday = findViewById(R.id.day);
        Tvweather = findViewById(R.id.Tvweather);
        Tvwind = findViewById(R.id.Tvwind);
        Tvdoam = findViewById(R.id.Tvdoam);
        Tvgioview = findViewById(R.id.Tvgioview);
        Tvthu = findViewById(R.id.Tvthu);
        // baonhapvao.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView6time = findViewById(R.id.recyclerview6time);

        dBsetting.addSetting(settingsql);
//        if (checkPlayServices()) {
//            // Building the GoogleApi client
//            buildGoogleApiClient();
//        }
        if (dBsetting.getAllSetting().get(0).getLanguage() == 1) {
            Tvdoam.setText("Humidity");
            Tvgioview.setText("Wind");
        }


        Imv_icon_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Seting.class);
                startActivity(intent);
            }
        });
        Relenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(View.VISIBLE);
            }
        });

        Imv_icon_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent22 = getIntent();
        String value1 = intent22.getStringExtra("tendiadiem");
        if (value1 != null) {
            int kcl123 = 0;
            if (value1.matches("^[a-z A-Z]{1,50}\\W\\S+$")) {
                kcl123 = 1;
            } else {
                kcl123 = 2;
            }
            if (kcl123 == 1) {
                GetCurrentWeatherData(value1, latitude, longitude, searh);
                GetCurrentWeatherData2(value1 + ",VN", latitude, longitude);
            } else
                GetCurrentWeatherData(value1, latitude, longitude, searh);
            GetCurrentWeatherData2(value1, latitude, longitude);
            value1 = null;
        } else {
            GetCurrentWeatherData(null, latitude, longitude, 0);
            GetCurrentWeatherData2(null, latitude, longitude);
        }

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bong);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.quay);


        Imvsearch.setOnClickListener(new View.OnClickListener() {
            int kcl = 0;
            int l = 0;

            @Override
            public void onClick(View v) {
                searh = 1;
                closKeyboard();
                editText.setVisibility(View.GONE);

                String dklm = editText.getText().toString();
                if (dklm.matches("^[a-z A-Z]{1,50}\\W\\S+$")) {
                    kcl = 1;
                } else {
                    kcl = 2;
                }
                if (kcl == 1) {
                    GetCurrentWeatherData(dklm, latitude, longitude, searh);
                    GetCurrentWeatherData2(dklm + ",VN", latitude, longitude);
                } else
                    GetCurrentWeatherData(dklm, latitude, longitude, searh);
                GetCurrentWeatherData2(dklm, latitude, longitude);
                l++;

            }


        });

    }

    public void closKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void GetCurrentWeatherData(final String data, double Latitude, double Longitude, final int searh1) {

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "RONG";
        if (data == null) {
            url = "http://api.openweathermap.org/data/2.5/weather?lat=" + Latitude + "&lon=" + Longitude + "&units=metric&appid=88d9f8ca61bbc88cd5d3d687c28937b9";

        } else
            url = "http://api.openweathermap.org/data/2.5/weather?q=" + data + "&units=metric&appid=88d9f8ca61bbc88cd5d3d687c28937b9";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            // bóc tách json của thời tiết trong ngày (hình tròn)
                            JSON.JSONWEATHER(response, weathertt);

//set tên của địa điểm
                            Tvplace.setText(weathertt.getDiadiem());
// lấy giờ của địa điêm đấy tại thời điểm tìm kiếm
                            textView.setText(weathertt.getTimeweather());

                            // check cài đặt để set đơn vị đo nhiệt độ
                            if (dBsetting.getAllSetting().get(0).getNhietdost() == 1) {
                                Tvtemperature.setText((int) (weathertt.getNhietdo() * 1.8 + 32) + "");
                                Imvdof.setImageResource(R.drawable.dof);
                            } else
                                Tvtemperature.setText(weathertt.getNhietdo() + "");



                            if (dBsetting.getAllSetting().get(0).getLanguage() == 1) {
                                Tvthu.setText(weathertt.getThu());
                            } else
                                Tvthu.setText(ttthoitiet.thu(weathertt.getThu()));

                            Tvday.setText(weathertt.getDayweather());

                            if (dBsetting.getAllSetting().get(0).getTdgio() == 1) {
                                Tvwind.setText(weathertt.getTocdogio() * 1.943844 + "mph/h");
                            } else {
                                if (dBsetting.getAllSetting().get(0).getTdgio() == 2) {
                                    Tvwind.setText(weathertt.getTocdogio() * 3.6 + "km/h");
                                } else
                                    Tvwind.setText(weathertt.getTocdogio() + "m/s");
                            }
/// set Ngôn ngữ của text
                            if (dBsetting.getAllSetting().get(0).getLanguage() == 1) {
                                Tvweather.setText(weathertt.getTrangthaithoitietweather());
                            } else Tvweather.setText(ttthoitiet.dich(weathertt.getIdWeather()));


                            if (searh1 == 1) {
                                if (dBsetting.getAllSetting().get(0).getLanguage() == 1) {
                                    historyMa = new history(weathertt.getDiadiem(), weathertt.getTimeweather(), weathertt.getNhietdo(), weathertt.getHuonggio(), weathertt.getTrangthaithoitietweather(), weathertt.getDayweather());
                                    dbHistory.addHistory1(historyMa);
                                } else
                                    historyMa = new history(weathertt.getDiadiem(), weathertt.getTimeweather(), weathertt.getNhietdo(), weathertt.getHuonggio(), ttthoitiet.dich(weathertt.getIdWeather()), weathertt.getDayweather());
                                dbHistory.addHistory1(historyMa);

                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        Log.d("AAA", "Lỗi\n" + error.toString());
                    }
                });
        requestQueue.add(stringRequest);
    }

    public void GetCurrentWeatherData2(final String data, double Latitude, double Longitude) {

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "";
        if (data == null) {
            url = "http://api.openweathermap.org/data/2.5/forecast?lat=" + Latitude + "&lon=" + Longitude + "&units=metric&appid=88d9f8ca61bbc88cd5d3d687c28937b9";

        } else
            url = "http://api.openweathermap.org/data/2.5/forecast?q=" + data + "&units=metric&appid=88d9f8ca61bbc88cd5d3d687c28937b9";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSON.JSONWEATHERoneday(response, weathertt1, contacts);
                            if (dBsetting.getAllSetting().get(0).getNhietdost() == 1) {
                                for (int i = 0; i < contacts.size(); i++) {
                                    contacts.get(i).setNhietdo((int) (contacts.get(i).getNhietdo() * 1.8 + 32));
                                }
                                for (int i = 0; i < contacts.size(); i++) {
                                    contacts.get(i).setTvcf(1);
                                }
                            }

                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 1, RecyclerView.HORIZONTAL, false);
                            adapterContact = new AdapterContact(contacts);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapterContact);

                            if (dBsetting.getAllSetting().get(0).getLanguage() == 2) {
                                JSON.JSONWEATHERoneday6timevn(response, weathertt1, contacts6time);

                            } else {
                                JSON.JSONWEATHERoneday6time(response, weathertt1, contacts6time);
                            }

                            if (dBsetting.getAllSetting().get(0).getNhietdost() == 1) {
                                for (int i = 0; i < contacts6time.size(); i++) {
                                    contacts6time.get(i).setNhietdo(contacts6time.get(i).getNhietdo() - 1000);
                                }
                            }

                            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getBaseContext(), RecyclerView.HORIZONTAL, false);

                            adapterContect6time = new AdapterContect6time(contacts6time);
                            recyclerView6time.setLayoutManager(layoutManager2);
                            recyclerView6time.setAdapter(adapterContect6time);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        Log.d("AAA", "Lỗi\n" + error.toString());
                    }
                });
        requestQueue.add(stringRequest);
    }
}
