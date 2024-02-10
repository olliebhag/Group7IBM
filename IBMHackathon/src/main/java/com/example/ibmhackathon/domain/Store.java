package com.example.ibmhackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// TODO - Add fields for store (e.g. name, location, opening hours, contact, webpage)
// TODO - Local business API?

@Entity
public class Store {
        @Id @GeneratedValue
        private long id;
        private String name;
        @OneToOne
        private Location location;
        private String openingHours;
        private String contact;
        private String webpage;

        // getters and setters
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

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(String openingHours) {
            this.openingHours = openingHours;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getWebpage() {
            return webpage;
        }

        public void setWebpage(String webpage) {
            this.webpage = webpage;
        }
    }

