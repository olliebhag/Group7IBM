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
    public static List<Store> stores = new ArrayList<>();
    public static User user1 = new User();
    public static User user2 = new User();

    public static void main(String[] args) {
        SpringApplication.run(IbmHackathon2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Store Tesco = new Store();
        Tesco.setId(0);
        Tesco.setName("Tesco");
        Location Tesco_loc = new Location();
        Tesco_loc.setLat_long("52.619820, -1.132340");
        stores.add(Tesco);

        user1.setFname("Ben");
        user1.setLname("Seager");
        user1.setUname(("BSeager"));
        user1.setEmail("benseager@gmail.com");
        user1.setPassword("hackathon");
        user1.setPhone("0700111222");
        // user1.setDob("19/11/2003");
        user1.setMale(Boolean.TRUE);

        Appointment appointment1 = new Appointment();
        appointment1.setId(1);
        appointment1.setDriver(user1);
        // appointment1.setDate("11/02/2024");
        appointment1.setStore(Tesco);
        appointment1.setPickUp(Tesco_loc);

        appointments.add(appointment1);

        Store sainsburys = new Store();
        sainsburys.setId(1);
        sainsburys.setName("Sainsburys");
        Location sainsburys_Loc = new Location();
        sainsburys_Loc.setLat_long("40.7128, -74.0060");
        stores.add(sainsburys);

        user2.setFname("Alice");
        user2.setLname("Johnson");
        user2.setUname("AliceJ");
        user2.setEmail("alicejohnson@gmail.com");
        user2.setPassword("securepassword");
        user2.setPhone("1234567890");
        user2.setMale(false);

        Appointment appointment2 = new Appointment();
        appointment2.setId(2);
        appointment2.setDriver(user2);
        appointment2.setStore(sainsburys);
        appointment2.setPickUp(sainsburys_Loc);

        appointments.add(appointment2);

        }
}
