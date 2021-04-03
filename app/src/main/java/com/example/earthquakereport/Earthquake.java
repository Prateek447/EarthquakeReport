package com.example.earthquakereport;

public class Earthquake {

    private  String mag;
    private String place;
    private  String date;

    public Earthquake(String mag, String place, String date) {
        this.mag=mag;
          this.place=place;
          this.date=date;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
