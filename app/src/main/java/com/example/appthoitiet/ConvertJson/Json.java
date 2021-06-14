package com.example.appthoitiet.ConvertJson;

import android.util.Log;

import com.example.appthoitiet.Model.Contect;
import com.example.appthoitiet.Model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class
Json {

    trangthaithoitiet ttthoitiet = new trangthaithoitiet();
    convert convertnew = new convert();
    Contect contect123;
    List<Contect> contectsList = new ArrayList<Contect>();
    Weather weather = new Weather();


    public Json() {
    }

    public Json(Weather weather) {
        this.weather = weather;
    }

    public void JSONWEATHER(String weatherjson, Weather weather) throws JSONException, IOException {

        JSONObject jsonObject = new JSONObject(weatherjson);
        String name = jsonObject.getString("name");
        int day = jsonObject.getInt("dt");
        weather.setDiadiem(name);

        JSONObject jsonObject1nhietdo = jsonObject.getJSONObject("main");
        int nhietdo = jsonObject1nhietdo.getInt("temp");
        weather.setNhietdo(nhietdo);


        long l = Long.valueOf(day);
        Date date = new Date(l * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE");
        String thu = simpleDateFormat2.format(date);
        String Day = simpleDateFormat.format(date);
        String time = simpleDateFormat1.format(date);
        weather.setDayweather(Day);
        weather.setThu(thu);
        weather.setTimeweather(time);

        JSONObject jsonObject1Wind = jsonObject.getJSONObject("wind");
        double gio = jsonObject1Wind.getDouble("speed");
        weather.setTocdogio(gio);


        JSONArray mang = jsonObject.getJSONArray("weather");
        Log.d("JSONARRAY_RESUST", "" + mang.toString());
        int idweather = 0;
        String iconweather = "rong";
        String description = "";
        for (int i = 0; i < mang.length(); i++) {

            JSONObject cit = mang.getJSONObject(i);
            Log.d("JSONOBJECT_RESULT", "" + cit.toString());

            idweather = cit.getInt("id");
            iconweather = cit.getString("icon");
            description = cit.getString("description");

        }
        int iconthoitiet = 0;
        weather.setHuonggio(iconweather);
        weather.setIcon(convertnew.convertweather(iconweather, iconthoitiet));

        weather.setTrangthaithoitietweather(description);
        weather.setIdWeather(idweather);


    }


    public void JSONWEATHERoneday(String weatheroneday, Weather weather1, List<Contect> contectsList) throws JSONException {
        JSONObject jsonObject = new JSONObject(weatheroneday);
        JSONArray mang1 = jsonObject.getJSONArray("list");
        Log.d("JSONARRAY_RESUST", "" + mang1.toString());
        contectsList.clear();
        for (int i = 0; i < 8; i++) {//mang1.length()
            JSONObject cit = mang1.getJSONObject(i);
            Log.d("JSONOBJECT_RESULT", "" + cit.toString());

            JSONObject jsonObject1nhietdo = cit.getJSONObject("main");
            int nhietdo = jsonObject1nhietdo.getInt("temp");
            int doam = jsonObject1nhietdo.getInt("humidity");


            int day56 = cit.getInt("dt");

            Long l2 = Long.valueOf(day56 - 7 * 60 * 60);
            Date date = new Date((l2 * 1000L));

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
            String time1 = simpleDateFormat1.format(date);


            JSONArray weathermini = cit.getJSONArray("weather");
            Log.d("JSONARRAY_RESUST", "" + weathermini.toString());

            String iconweather = "rong";
            for (int i2 = 0; i2 < weathermini.length(); i2++) {

                JSONObject cit2 = weathermini.getJSONObject(i2);
                Log.d("JSONOBJECT_RESULT", "" + cit2.toString());

                iconweather = cit2.getString("icon");


            }
            int iconthoitiet = 0;

            iconthoitiet=convertnew.convertweather(iconweather,iconthoitiet);


            contect123 = new Contect(time1, iconthoitiet, nhietdo, doam);
            contectsList.add(contect123);


        }


    }

    public void JSONWEATHERoneday6time(String weatheroneday, Weather weather1, List<Contect> contectsList) throws JSONException {
        JSONObject jsonObject = new JSONObject(weatheroneday);
        JSONArray mang1 = jsonObject.getJSONArray("list");
        Log.d("JSONARRAY_RESUST", "" + mang1.toString());
        contectsList.clear();
        for (int i = 0; i < mang1.length(); i++) {//
            JSONObject cit = mang1.getJSONObject(i);
            Log.d("JSONOBJECT_RESULT", "" + cit.toString());


            JSONObject jsonObject1nhietdo = cit.getJSONObject("main");
            int nhietdo = jsonObject1nhietdo.getInt("temp");
            int doam = jsonObject1nhietdo.getInt("humidity");


            JSONArray weathermini = cit.getJSONArray("weather");
            Log.d("JSONARRAY_RESUST", "" + weathermini.toString());

            String iconweather = "rong";
            for (int i2 = 0; i2 < weathermini.length(

            ); i2++) {

                JSONObject cit2 = weathermini.getJSONObject(i2);
                Log.d("JSONOBJECT_RESULT", "" + cit2.toString());

                iconweather = cit2.getString("icon");


            }
            int iconthoitiet = 0;
            iconthoitiet=convertnew.convertweather(iconweather,iconthoitiet);


            int day56 = cit.getInt("dt");
            Long l2 = Long.valueOf(day56 - 7 * 60 * 60);
            Date date = new Date((l2 * 1000L));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
            // SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE yyyy-MM-dd HH-mm-ss");
            String time1 = simpleDateFormat1.format(date);
            String time2 = simpleDateFormat.format(date);
            if (time1.equals("06:00")) {

                contect123 = new Contect(time2, iconthoitiet, nhietdo, doam);
                contectsList.add(contect123);

            }


        }


    }

    public void JSONWEATHERoneday6timevn(String weatheroneday, Weather weather1, List<Contect> contectsList) throws JSONException {
        JSONObject jsonObject = new JSONObject(weatheroneday);
        JSONArray mang1 = jsonObject.getJSONArray("list");
        Log.d("JSONARRAY_RESUST", "" + mang1.toString());
        contectsList.clear();
        for (int i = 0; i < mang1.length(); i++) {//


            JSONObject cit = mang1.getJSONObject(i);


            Log.d("JSONOBJECT_RESULT", "" + cit.toString());

            JSONObject jsonObject1nhietdo = cit.getJSONObject("main");
            int nhietdo = jsonObject1nhietdo.getInt("temp");
            int doam = jsonObject1nhietdo.getInt("humidity");




            JSONArray weathermini = cit.getJSONArray("weather");
            Log.d("JSONARRAY_RESUST", "" + weathermini.toString());

            String iconweather = "rong";
            for (int i2 = 0; i2 < weathermini.length(); i2++) {

                JSONObject cit2 = weathermini.getJSONObject(i2);
                Log.d("JSONOBJECT_RESULT", "" + cit2.toString());

                iconweather = cit2.getString("icon");


            }
            int iconthoitiet = 0;
          iconthoitiet=convertnew.convertweather(iconweather,iconthoitiet);



            int day56 = cit.getInt("dt");
            Long l2 = Long.valueOf(day56 - 7 * 60 * 60);
            Date date = new Date((l2 * 1000L));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
            String time1 = simpleDateFormat1.format(date);
            String time2 = simpleDateFormat.format(date);
            if (time1.equals("06:00")) {

                contect123 = new Contect(ttthoitiet.thu(time2), iconthoitiet, nhietdo, doam);
                contectsList.add(contect123);

            }


        }


    }

}

















