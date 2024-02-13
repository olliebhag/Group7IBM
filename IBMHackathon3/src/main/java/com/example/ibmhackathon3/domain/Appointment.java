package com.example.ibmhackathon3.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.join;

public class Appointment {
    private static long previousId = 0;
    private long id;
    private User driver;
    private List<User> participants = new ArrayList<User>();
    private Date date;
    private GeoLocation pickUp;
    private Store store;

    public Appointment() {
        this.id = previousId++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void addParticipant(User participant) {
        this.participants.add(participant);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String date () {
        String date = this.date.toString();
        date = date.split(" ")[0] + " " + date.split(" ")[1] + " " + date.split(" ")[2];
        return date;
    }

    public String time () {
        String date = this.date.toString();
        date = date.split(" ")[3].split(":")[0] + ":" + date.split(" ")[3].split(":")[1];
        return date;
    }

    public GeoLocation getPickUp() {
        return pickUp;
    }

    public void setPickUp(GeoLocation pickUp) {
        this.pickUp = pickUp;
    }

    public void setPickUp(double lat, double lon) {
        this.pickUp = new GeoLocation();
        this.pickUp.setLatLon(lat, lon);
    }

    public double getPickUpDistance (GeoLocation location) {
        return this.pickUp.distance(location);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void removeParticipant(User user) {
        this.participants.remove(user);
    }
}
