package com.example.ibmhackathon2.domain;

public class Vehicle {

    private String reg; //Registration Plate

    private User driver; //Owner
    private short seats; //Number of seats
    private String license; //Drivers license

    public void setRegistration(String reg) {
        this.reg = reg;
    }

    public String getRegistration() {
        return this.reg;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public User getDriver() {
        return this.driver;
    }

    public void setSeats(short seats) {
        this.seats = seats;
    }

    public short getSeats() {
        return this.seats;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
