package com.example.emily.whph2;

/**
 * Created by Emily on 11/13/15.
 */
public class StudyBuddy {
    private String name;
    private String location;
    private String startTime;
    private String subject;
    private double lat;
    private double lon;

    public StudyBuddy() {}

    public StudyBuddy(String name, String location, String startTime, String subject) {
        lat = 0.0;
        lon = 0.0;
        this.location = location;
        this.name = name;
        this.startTime = startTime;
        this.subject = subject;

        if(this.location.equals("Library")) {
            lat = 34.102454;
            lon = -117.712661;
        }
        else if(this.location.equals("Millikan")) {
            lat = 34.099901;
            lon = -117.714161;
        }
        else if (this.location.equals("Edmunds")) {
            lat = 34.099896;
            lon = -117.713220;
        }
        else {
            lat = 34.098119;
            lon = -117.713817;
        }

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

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
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
