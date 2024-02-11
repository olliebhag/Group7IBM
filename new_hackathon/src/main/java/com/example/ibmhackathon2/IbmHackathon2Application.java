package com.example.ibmhackathon2;

import com.example.ibmhackathon2.domain.Appointment;
import com.example.ibmhackathon2.domain.Location;
import com.example.ibmhackathon2.domain.Store;
import com.example.ibmhackathon2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IbmHackathon2Application implements CommandLineRunner {

    public static List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(IbmHackathon2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // TODO - Add courses to database here
        Store morrisons = new Store();
        Location morrisons_loc = new Location();
        morrisons_loc.setLat_long("52.619820, -1.132340");

        User user1 = new User();
        user1.setFname("Ben");
        user1.setLname("Seager");
        user1.setUname(("BSeager"));
        user1.setEmail("benseager@gmail.com");
        user1.setPassword("hackathon");
        user1.setPhone("0700111222");
        // user1.setDob("19/11/2003");
        user1.setMale(Boolean.TRUE);

        Appointment appointment1 = new Appointment();
        appointment1.setDriver(user1);
        // appointment1.setDate("11/02/2024");
        appointment1.setStore(morrisons);
        appointment1.setPickUp(morrisons_loc);

        appointments.add(appointment1);
    }
}
