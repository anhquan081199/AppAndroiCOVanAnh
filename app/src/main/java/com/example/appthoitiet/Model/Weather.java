package com.example.appthoitiet.Model;


public class Weather {
    private String huonggio;
    private String diadiem;
    private String dayweather;
    private String timeweather;
    private String gio;
    private String trangthaithoitietweather, trangthaittvn, thu;

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTrangthaittvn() {
        return trangthaittvn;
    }

    public void setTrangthaittvn(String trangthaittvn) {
        this.trangthaittvn = trangthaittvn;
    }

    public String getIcontt() {
        return icontt;
    }

    public void setIcontt(String icontt) {
        this.icontt = icontt;
    }

    private String icontt;

    private int nhietdo, nhietdocaonhat, nhietdothapnhat, idWeather, icon;

    private double apsuatkhiquyen, apsuatkhiquyentrenmatdat, doam, luongmuakhoiluongtuyet, tocdogio;


    public Weather() {
    }

    public String getTrangthaithoitietweather() {
        return trangthaithoitietweather;
    }

    public void setTrangthaithoitietweather(String trangthaithoitietweather) {
        this.trangthaithoitietweather = trangthaithoitietweather;
    }

    public double getTocdogio() {
        return tocdogio;
    }

    public void setTocdogio(double tocdogio) {
        this.tocdogio = tocdogio;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Weather(String huonggio, int nhietdo, int nhietdocaonhat, int nhietdothapnhat, int idWeather, double apsuatkhiquyen, double apsuatkhiquyentrenmatdat, String gio, double doam, double luongmuakhoiluongtuyet, String diadiem, String dayweather, String timeweather, String trangthaithoitietweather, double tocdogio, int icon) {
        this.huonggio = huonggio;
        this.nhietdo = nhietdo;
        this.nhietdocaonhat = nhietdocaonhat;
        this.nhietdothapnhat = nhietdothapnhat;
        this.idWeather = idWeather;
        this.apsuatkhiquyen = apsuatkhiquyen;
        this.apsuatkhiquyentrenmatdat = apsuatkhiquyentrenmatdat;
        this.gio = gio;
        this.doam = doam;
        this.luongmuakhoiluongtuyet = luongmuakhoiluongtuyet;
        this.tocdogio = tocdogio;
        this.trangthaithoitietweather = trangthaithoitietweather;
        this.diadiem = diadiem;
        this.dayweather = dayweather;
        this.icon = icon;
        this.timeweather = timeweather;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getHuonggio() {
        return huonggio;
    }

    public void setHuonggio(String huonggio) {
        this.huonggio = huonggio;
    }

    public int getNhietdo() {
        return nhietdo;
    }

    public void setNhietdo(int nhietdo) {
        this.nhietdo = nhietdo;
    }

    public int getNhietdocaonhat() {
        return nhietdocaonhat;
    }

    public void setNhietdocaonhat(int nhietdocaonhat) {
        this.nhietdocaonhat = nhietdocaonhat;
    }

    public int getNhietdothapnhat() {
        return nhietdothapnhat;
    }

    public void setNhietdothapnhat(int nhietdothapnhat) {
        this.nhietdothapnhat = nhietdothapnhat;
    }

    public int getIdWeather() {
        return idWeather;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    public double getApsuatkhiquyen() {
        return apsuatkhiquyen;
    }

    public void setApsuatkhiquyen(double apsuatkhiquyen) {
        this.apsuatkhiquyen = apsuatkhiquyen;
    }

    public double getApsuatkhiquyentrenmatdat() {
        return apsuatkhiquyentrenmatdat;
    }

    public void setApsuatkhiquyentrenmatdat(double apsuatkhiquyentrenmatdat) {
        this.apsuatkhiquyentrenmatdat = apsuatkhiquyentrenmatdat;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public double getDoam() {
        return doam;
    }

    public void setDoam(double doam) {
        this.doam = doam;
    }

    public double getLuongmuakhoiluongtuyet() {
        return luongmuakhoiluongtuyet;
    }

    public void setLuongmuakhoiluongtuyet(double luongmuakhoiluongtuyet) {
        this.luongmuakhoiluongtuyet = luongmuakhoiluongtuyet;
    }

    public String getDayweather() {
        return dayweather;
    }

    public void setDayweather(String dayweather) {
        this.dayweather = dayweather;
    }

    public String getTimeweather() {
        return timeweather;
    }

    public void setTimeweather(String timeweather) {
        this.timeweather = timeweather;
    }
}
