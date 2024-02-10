package com.example.ibmhackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

// TODO - List of vehicles, get appointments,

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String fname;
    private String lname;
    private String uname;
    private String email;
    private String password;
    private String phone;
    private Date dob; //Date of birth
    private Boolean isMale;
    @OneToMany
    private List<Vehicle> vehicles;
}
