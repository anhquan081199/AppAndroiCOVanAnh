package com.example.appthoitiet.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appthoitiet.Adapter.HistoryAdapter;
import com.example.appthoitiet.DBManage.DBHistory;
import com.example.appthoitiet.DBManage.DBsetting;
import com.example.appthoitiet.R;
import com.example.appthoitiet.Model.history;
import com.example.appthoitiet.Model.setting;

import java.util.ArrayList;

public class Activity_Seting extends AppCompatActivity {

    TextView Tvxong, Tvthoitietst, Tvngonngust, Tvnhietdo, Tvtocdogiost, Tvlichsust, Tvsetting;
    ListView listView123;
    Button language1, language2, BtF, BtC, Bttd1, Bttd2, Bttd3;
    ArrayList<history> historyArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView123 = findViewById(R.id.Lvhistory);
        Tvxong = findViewById(R.id.Tvxong);
        language1 = findViewById(R.id.language1);
        language2 = findViewById(R.id.language2);
        BtF = findViewById(R.id.BtF);
        BtC = findViewById(R.id.BtC);
        Bttd1 = findViewById(R.id.Bttd1);
        Bttd2 = findViewById(R.id.Bttd2);
        Bttd3 = findViewById(R.id.Bttd3);
        Tvthoitietst = findViewById(R.id.Tvthoitietst);
        Tvngonngust = findViewById(R.id.Tvngonngust);
        Tvnhietdo = findViewById(R.id.Tvnhietdost);
        Tvtocdogiost = findViewById(R.id.Tvtocdogio);
        Tvlichsust = findViewById(R.id.Tvlichsust);
        Tvsetting = findViewById(R.id.Tvsetting);

        historyArrayAdapter = new ArrayList<>();

        DBHistory dbHistory = new DBHistory(this);
        historyArrayAdapter = dbHistory.getAllHistory();
        final DBsetting dBsetting = new DBsetting(this);



        HistoryAdapter historyAdapter = new HistoryAdapter(this, R.layout.item_lisview, historyArrayAdapter);
        listView123.setAdapter(historyAdapter);


        listView123.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentlistview = new Intent(Activity_Seting.this, MainActivity.class);
                intentlistview.putExtra("tendiadiem", historyArrayAdapter.get(position).getName());
                startActivity(intentlistview);
            }
        });


        Tvxong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Seting.this, MainActivity.class);
                startActivity(intent);
            }
        });
        language1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(1, 2, 3, 1);
                dBsetting.Updatelanguage(settingsql_1);
                Tvthoitietst.setText("Weather");
                Tvngonngust.setText("Language");
                Tvnhietdo.setText("Temperature");
                Tvtocdogiost.setText("Wind speed");
                Tvlichsust.setText("History");
                Tvsetting.setText("Setting");
                Tvxong.setText("Complete");

            }
        });
        language2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 2, 3, 1);
                dBsetting.Updatelanguage(settingsql_1);
                Tvthoitietst.setText("Thời tiết");
                Tvngonngust.setText("Ngôn ngữ");
                Tvnhietdo.setText("Nhiệt độ");
                Tvtocdogiost.setText("Tốc độ gió");
                Tvlichsust.setText("Lịch sử");
                Tvsetting.setText("Cài đặt");
                Tvxong.setText("Xong");

            }
        });
        BtF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 1, 3, 1);
                dBsetting.Updatenhietdo(settingsql_1);

            }
        });
        BtC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 2, 3, 1);
                dBsetting.Updatenhietdo(settingsql_1);

            }
        });
        Bttd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 1, 1, 1);
                dBsetting.Updatetdgio(settingsql_1);

            }
        });
        Bttd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 1, 2, 1);
                dBsetting.Updatetdgio(settingsql_1);

            }
        });

        Bttd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting settingsql_1 = new setting(2, 1, 3, 1);
                dBsetting.Updatetdgio(settingsql_1);

            }
        });


        if (dBsetting.getAllSetting().get(0).getLanguage() == 1) {
            Tvthoitietst.setText("Weather");
            Tvngonngust.setText("Language");
            Tvnhietdo.setText("Temperature");
            Tvtocdogiost.setText("Wind speed");
            Tvlichsust.setText("History");
            Tvsetting.setText("Setting");
            Tvxong.setText("Complete");

        }


    }
}
