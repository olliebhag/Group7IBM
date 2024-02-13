package com.example.ibmhackathon3.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private static long previousId = 0;
    private long id;
    private String username;
    private String email;
    private String[] name = new String[2];
    private String phone;
    private Date dob;
    private Boolean isMale;
    private GeoLocation currentLocation;
    private List<GeoLocation> preferredPickup = new ArrayList<GeoLocation>();
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private int sharedRides = 0;
    private double distance = 0;

    public User() {
        this.id = previousId++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String nameToString () {
        return name[0] + " " + name[1];
    }

    public String getFname() {
        return name[0];
    }

    public void setFname(String fname) {
        name[0] = fname;
    }

    public String getLname() {
        return name[1];
    }

    public void setLname(String lname) {
        name[1] = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int calcAge () {
        Date now = new Date();
        int age = now.getYear() - dob.getYear() + 1900;
        if (now.getMonth() < dob.getMonth() || (now.getMonth() == dob.getMonth() && now.getDate() < dob.getDate())) {
            age--;
        }
        return age;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public GeoLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(GeoLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentLocation(double lat, double lon) {
        GeoLocation location = new GeoLocation();
        location.setLatLon(lat, lon);
        this.currentLocation = location;
    }

    public List<GeoLocation> getPreferredPickup() {
        return preferredPickup;
    }

    public void setPreferredPickup(List<GeoLocation> preferredPickup) {
        this.preferredPickup = preferredPickup;
    }

    public void addPreferredPickup(GeoLocation location) {
        preferredPickup.add(location);
    }

    public void addPreferredPickup(double lat, double lon) {
        GeoLocation location = new GeoLocation();
        location.setLatLon(lat, lon);
        preferredPickup.add(location);
    }

    public void removePreferredPickup(GeoLocation location) {
        preferredPickup.remove(location);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public int getSharedRides() {
        return sharedRides;
    }

    public void setSharedRides(int sharedRides) {
        this.sharedRides = sharedRides;
    }

    public void addSharedRide() {
        sharedRides++;
    }

    public double getDistance () {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getStars () {
        double stars = 0;
        for (Vehicle vehicle : vehicles) {
            stars += vehicle.getStars();
        }
        stars /= vehicles.size();
        return stars;
    }

    public double getDistanceTravelled () {
        double distance = this.distance;
        for (Vehicle vehicle : vehicles) {
            distance += vehicle.getDistanceTravelled();
        }
        return distance;
    }

    public int calcTotalPools () {
        int totalPools = getSharedRides();
        for (Vehicle vehicle : vehicles) {
            totalPools += vehicle.getSharedRides();
        }
        return totalPools;
    }



}
