package com.example.appthoitiet.ConvertJson;

import com.example.appthoitiet.R;

public class convert {
    public convert() {
    }

    public int convertweather(String a, int b){
        if(a.equals("01d")){
            b= R.drawable.sun;
        }
        if(a.equals("01n")){
           b=R.drawable.moon;
        }
        if(a.equals("02d")){
            b=R.drawable.sun1;
        }
        if(a.equals("02n")){
            b=R.drawable.sunnight;
        }
        if(a.equals("03d")){
            b=R.drawable.cloud;
        }
        if(a.equals("03n")){
            b=R.drawable.cloud;
        }
        if(a.equals("04d")||a.equals("04n")){
            b=R.drawable.clouds;
        }
        if(a.equals("09d")||a.equals("09n")){
            b=R.drawable.rain;
        }
        if(a.equals("10d")){
            b=R.drawable.icon8ddd;
        }
        if(a.equals("10n")){
            b=R.drawable.rain;
        }
        if(a.equals("11d")||a.equals("11n")){
            b=R.drawable.storm;
        }
        if(a.equals("13d")||a.equals("13n")){
            b=R.drawable.snowflake;
        }

        if(a.equals("50d")||a.equals("50n")){

            b=R.drawable.fog;
        }
        return b;
    }
}
