package com.example.ibmhackathon2.controller;

import com.example.ibmhackathon2.IbmHackathon2Application;
import com.example.ibmhackathon2.domain.Appointment;
import com.example.ibmhackathon2.domain.User;
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
        User user1 = new User();
        model.addAttribute("events", IbmHackathon2Application.appointments);
        model.addAttribute("user", IbmHackathon2Application.user1);
        return "app/home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "app/profile";
    }
    // TODO - Handle web requests (e.g. GET /, GET /appointments, POST /appointments, GET /users, POST /users)

    @RequestMapping("/upcoming")
    public String upcoming(Model model) {
        model.addAttribute("events", IbmHackathon2Application.appointments);
        model.addAttribute("stores", IbmHackathon2Application.stores);
        model.addAttribute("user", IbmHackathon2Application.user1);
        return "app/search-appointment";
    }

    @RequestMapping("/search")
    public String stores(Model model) {
        model.addAttribute("stores", IbmHackathon2Application.stores);
        model.addAttribute("user", IbmHackathon2Application.user1);
        return "app/stores";
    }
}