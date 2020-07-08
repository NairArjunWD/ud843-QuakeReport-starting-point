package com.example.android.quakereport;

import java.util.Date;

public class EarthquakeList {
    private String mag;
    private String location;
    private String time;
    private long timeInMilliseconds;

    public EarthquakeList(String mag, String location, long timeInMilliseconds){
        this.mag = mag;
        this.location = location;
        this.timeInMilliseconds = timeInMilliseconds;
    }
    public String getMag(){
        return mag;

    }
    public String getLocation(){
        return location;
    }
    public String getTime(){
        return time;
    }
    public long getTimeInMilliseconds(){
        return timeInMilliseconds;
    }



}
