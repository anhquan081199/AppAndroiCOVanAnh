package com.example.appthoitiet.Model;

public class setting {
    private int language, nhietdost, tdgio;

    public setting() {
    }

    private int id;

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getNhietdost() {
        return nhietdost;
    }

    public void setNhietdost(int nhietdost) {
        this.nhietdost = nhietdost;
    }

    public int getTdgio() {
        return tdgio;
    }

    public void setTdgio(int tdgio) {
        this.tdgio = tdgio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public setting(int language, int nhietdost, int tdgio, int id) {
        this.language = language;
        this.nhietdost = nhietdost;
        this.tdgio = tdgio;
        this.id = id;
    }
    public setting(int language, int nhietdost, int tdgio) {
        this.language = language;
        this.nhietdost = nhietdost;
        this.tdgio = tdgio;

    }
}
