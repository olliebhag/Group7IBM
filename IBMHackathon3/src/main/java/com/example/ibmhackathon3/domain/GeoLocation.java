package com.example.ibmhackathon3.domain;

public class GeoLocation {
    private static long previousId = 0;
    private long id;
    private double lat;
    private double lon;

    public GeoLocation() {
        this.id = previousId++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setLatLon(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double distance (GeoLocation location) {
        // Thank fuck for co-pilot - Jakob
        double lat1 = this.lat;
        double lon1 = this.lon;
        double lat2 = location.getLat();
        double lon2 = location.getLon();
        double R = 6371e3; // metres
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaphi = Math.toRadians(lat2-lat1);
        double deltagamma = Math.toRadians(lon2-lon1);
        double a = Math.sin(deltaphi/2) * Math.sin(deltaphi/2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(deltagamma/2) * Math.sin(deltagamma/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c;
        // Wonky maths
        double output = (double) Math.floor(d / 10f) / 100;
        return output;
    }
}
