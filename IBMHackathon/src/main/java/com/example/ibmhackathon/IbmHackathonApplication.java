package com.example.ibmhackathon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbmHackathonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IbmHackathonApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception {
        // TODO - Add default users and appointments for testing
    }
}