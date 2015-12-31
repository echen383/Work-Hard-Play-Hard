package com.example.emily.whph2;

/**
 * Created by Emily on 12/30/15.
 */
public class PlayBuddy {
    private String name;
    private String location;
    private String startTime;
    private String activity;
    private double lat;
    private double lon;

    public PlayBuddy() {}

    public PlayBuddy(String name, String location, String startTime, String activity) {
        lat = 0.0;
        lon = 0.0;
        this.location = location;
        this.name = name;
        this.startTime = startTime;
        this.activity = activity;

        //add lat/lon coordinates
//        if(this.location.equals("Library")) {
//            lat = 34.102454;
//            lon = -117.712661;
//        }
//        else if(this.location.equals("Millikan")) {
//            lat = 34.099901;
//            lon = -117.714161;
//        }
//        else if (this.location.equals("Edmunds")) {
//            lat = 34.099896;
//            lon = -117.713220;
//        }
//        else {
//            lat = 34.098119;
//            lon = -117.713817;
//        }

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
}
