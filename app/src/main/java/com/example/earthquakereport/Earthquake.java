package com.example.earthquakereport;

public class Earthquake {

    private  String mag;
    private String place;
    private  Long date;

    public Earthquake(String mag, String place, Long date) {
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

    public Long getTimeInMilliSeconds() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
