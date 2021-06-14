package com.example.appthoitiet.Model;

public class history {
    private String name;
    private String time;
    private String trangthaitt,icon;

    public String getTrangthaitt() {
        return trangthaitt;
    }

    public void setTrangthaitt(String trangthaitt) {
        this.trangthaitt = trangthaitt;
    }

    public String getDayandmonth() {
        return dayandmonth;
    }

    public void setDayandmonth(String dayandmonth) {
        this.dayandmonth = dayandmonth;
    }

    private String dayandmonth;
    private int temperature,id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public history() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public history(String name, String time, int temperature ,String icon,String trangthaitt,String dayandmonth) {
this.trangthaitt=trangthaitt;
this.dayandmonth=dayandmonth;
        this.name = name;
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
    }
    public history(String name, String time, int temperature, String icon) {

        this.name = name;
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
    }
    public history(String name, String time, int temperature, String icon,int id) {
        this.id=id;
        this.name = name;
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
    }
}
