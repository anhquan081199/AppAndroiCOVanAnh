package com.example.appthoitiet.Model;

public class Contect {
    private String time;
    private int icon;
    private int nhietdo;
    private int doam;

    public int getTvcf() {
        return tvcf;
    }

    public void setTvcf(int tvcf) {
        this.tvcf = tvcf;
    }

    private int tvcf;

    public Contect() {
    }

    @Override
    public String toString() {
        return "Contect{" +
                "time='" + time + '\'' +
                ", icon=" + icon +
                ", nhietdo=" + nhietdo +
                '}';
    }

    public Contect(String time, int icon, int nhietdo,int doam) {
        this.time = time;
        this.icon = icon;
        this.nhietdo = nhietdo;
        this.doam=doam;

    }

    public int getDoam() {
        return doam;
    }

    public void setDoam(int doam) {
        this.doam = doam;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getNhietdo() {
        return nhietdo;
    }

    public void setNhietdo(int nhietdo) {
        this.nhietdo = nhietdo;
    }
}
