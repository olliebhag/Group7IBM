package com.example.ibmhackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login/login-form";
    }
    // TODO - Handle login requests (e.g. GET /login, POST /login) and creating new users (e.g. GET /signup, POST /signup)
}
