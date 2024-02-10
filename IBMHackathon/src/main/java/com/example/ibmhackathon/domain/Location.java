package com.example.ibmhackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {
    // TODO - add Geolocation stuff hello
    @Id
    private String lat_long;
}
