package com.example.ibmhackathon3.domain;

public class Vehicle {
    private String reg; //Registration Plate
    private User driver; //Owner
    private int seats; //Number of seats
    private String license; //Drivers license
    private int stars; //Rating
    private int sharedRides = 0; //Number of shared rides
    private double distanceTravelled = 0; //Distance travelled
    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getSharedRides() {
        return sharedRides;
    }

    public void setSharedRides(int sharedRides) {
        this.sharedRides = sharedRides;
    }

    public void addSharedRide() {
        this.sharedRides++;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

}
