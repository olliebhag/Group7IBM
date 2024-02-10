package com.example.ibmhackathon.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Appointment {
    @Id @GeneratedValue
    private long id;
    @ManyToOne
    private User driver;
    @ManyToMany
    private List<User> passengers;
    private Date date;
    @ManyToOne
    private Location pickUp;
    @ManyToOne
    private Store store;
    private String groupChatId;

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

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(User passenger) {
        this.passengers.add(passenger);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getPickUp() {
        return pickUp;
    }

    public void setPickUp(Location pickUp) {
        this.pickUp = pickUp;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getGroupChat() {
        return groupChatId;
    }

    public void setGroupChat(String groupChatId) {
        this.groupChatId = groupChatId;
    }
}