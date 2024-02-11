package com.example.ibmhackathon2.controller;

import com.example.ibmhackathon2.IbmHackathon2Application;
import com.example.ibmhackathon2.domain.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @RequestMapping("/")
    public String start(Model model) {
        List<Appointment> appointments = new ArrayList<>();
        model.addAttribute("events", IbmHackathon2Application.appointments);
        return "app/home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "app/profile";
    }
    // TODO - Handle web requests (e.g. GET /, GET /appointments, POST /appointments, GET /users, POST /users)
}