package com.webdevuoit3230.FinalProject.controller;

// Spring MVC and session handling imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Marks this class as a Controller with URL mappings handled at "/home"
@Controller
@RequestMapping("/home")
public class HomeController {
    // Displays the main homepage
    @GetMapping
    public String displayHomepage() {
        return "homepage"; // Points to `homepage.html` Thymeleaf template
    }

    // Navigation methods to various pages (These methods redirect to respective
    // pages)
    @GetMapping("/customers")
    public String displayCustomerpage() {
        return "customers"; // Points to `customers.html`
    }

    @GetMapping("/services")
    public String displayServicepage() {
        return "services"; // Points to `services.html`
    }

    @GetMapping("/bookings")
    public String displayBookingpage() {
        return "bookings"; // Points to `bookings.html`
    }

    @GetMapping("/rooms")
    public String displayRoompage() {
        return "rooms"; // Points to `rooms.html`
    }

    @GetMapping("/tasks")
    public String displayTaskpage() {
        return "rooms"; // Example, typically would point to a `tasks.html`
    }
}
