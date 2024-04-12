package com.webdevuoit3230.FinalProject.controller;

import com.webdevuoit3230.FinalProject.service.ProvidedServiceService;
import com.webdevuoit3230.FinalProject.model.ProvidedService;
import com.webdevuoit3230.FinalProject.model.Booking;
import com.webdevuoit3230.FinalProject.service.BookingService;

import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ProvidedServiceController {

    private final BookingService bookingService;
    private final ProvidedServiceService providedServiceService;
    private final CustomerService customerService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService, BookingService bookingService, CustomerService customerService) {
        this.providedServiceService = providedServiceService;
        this.bookingService = bookingService;
        this.customerService = customerService;
    }
    
    @GetMapping
    public String displayServicePage(Model model) {
        model.addAttribute("services", providedServiceService.findAllServices());
        return "services";
    }
    
    @GetMapping("/list")
    public String listServices(Model model) {
        model.addAttribute("services", providedServiceService.findAllServices());
        model.addAttribute("customers", customerService.getAllCustomers()); // Adds list of all customers to the model.
        return "services";
    }

    @PostMapping
    public String addService(@RequestParam String serviceName, 
            @RequestParam String selectedService, 
            @RequestParam double servicePrice) {
        // Retrieve all bookings
        List<Booking> allBookings = bookingService.findAllBookings();

        // Create an empty list to store matching bookings
        for (Booking booking : allBookings) {
            if (booking.getCustomer().getName().equals(serviceName)) {
                ProvidedService providedService = new ProvidedService();
                // Set properties of the providedService object based on the booking
                providedService.setName(booking.getCustomer().getName());
                providedService.setDescription(booking.getRoom().getRoomNumber());
                providedService.setType(selectedService); // Set the type of service
                providedService.setPrice(servicePrice); // Set the price of the service
                // Set other properties as needed...
                providedServiceService.saveServices(providedService);
            }
        }

        // Redirect to the list endpoint to refresh the page and display the updated list
        return "redirect:/services";
    }
}
