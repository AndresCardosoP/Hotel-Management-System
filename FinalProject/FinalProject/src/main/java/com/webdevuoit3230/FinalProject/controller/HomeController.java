package com.webdevuoit3230.FinalProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String displayHomepage() {
        return "homepage";
    }

    @GetMapping("/customers")
    public String displayCustomerpage() {
        return "customers";
    }

    @GetMapping("/services")
    public String displayServicepage() {
        return "services";
    }

    @GetMapping("/bookings")
    public String displayBookingpage() {
        return "bookings";
    }

    @GetMapping("/rooms")
    public String displayRoompage() {
        return "rooms";
    }
    
    @GetMapping("/tasks")
    public String displayTaskpage() {
        return "rooms";
    }
}

