package com.example.ibmhackathon2.domain;

import java.util.Date;
import java.util.List;

// TODO - List of vehicles, get appointments,
public class User {

    private Long id;
    private String fname;
    private String lname;
    private String uname;
    private String email;
    private String password;
    private String phone;
    private Date dob; //Date of birth
    private Boolean isMale;
    private List<Vehicle> vehicles;
}
