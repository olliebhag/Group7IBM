package com.example.ibmhackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String start() {
        return "app/home";
    }
    // TODO - Handle web requests (e.g. GET /, GET /appointments, POST /appointments, GET /users, POST /users)
}
