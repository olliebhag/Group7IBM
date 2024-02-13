package com.example.ibmhackathon3.domain;

import java.util.HashMap;

public class Store {
    private static long previousId = 0;
    private long id;
    private String name;
    private GeoLocation location;
    private String address;
    private String phone;
    private String webpage;
    private HashMap<String, String[]> openingHours = new HashMap<String, String[]>();

    public Store() {
        this.id = previousId++;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public void setLocation(double lat, double lon) {
        this.location = new GeoLocation();
        this.location.setLatLon(lat, lon);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public HashMap<String, String[]> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(HashMap<String, String[]> openingHours) {
        this.openingHours = openingHours;
    }

    public void addOpeningHours(String day, String[] hours) {
        this.openingHours.put(day, hours);
    }
}
