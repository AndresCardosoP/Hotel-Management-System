package com.webdevuoit3230.FinalProject.controller;

import com.webdevuoit3230.FinalProject.model.Booking;
import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.service.BookingService;
import com.webdevuoit3230.FinalProject.service.CustomerService;
import com.webdevuoit3230.FinalProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Marks this class as a Controller where every method returns a domain object instead of a view.
@Controller
// Maps requests to /bookings path to the methods in this controller.
@RequestMapping("/bookings")
public class BookingController {

    // Dependency injection of services.
    private final BookingService bookingService;
    private final RoomService roomService;
    private final CustomerService customerService;

    // Constructor-based Dependency Injection.
    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.customerService = customerService;
    }

    // Handles GET requests to "/bookings", showing a list of bookings and forms for
    // adding a new booking.
    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAllBookings()); // Adds list of all bookings to the model.
        model.addAttribute("newBooking", new Booking()); // Adds a new Booking object to the model to be filled from the
                                                         // form.
        model.addAttribute("rooms", roomService.findAllRooms()); // Adds list of all rooms to the model.
        model.addAttribute("customers", customerService.getAllCustomers()); // Adds list of all customers to the model.
        return "bookings"; // Returns the Thymeleaf template name for listing and adding bookings.
    }

    // Handles POST requests to "/bookings", adding a new booking with provided
    // details.
    @PostMapping
    public String addBooking(@ModelAttribute("newBooking") Booking booking,
            @RequestParam Long roomId,
            @RequestParam Long customerId) {
        Room room = roomService.findRoomById(roomId); // Finds the room based on roomId.
        Customer customer = customerService.findById(customerId); // Finds the customer based on customerId.
        if (room != null && customer != null) {
            booking.setRoom(room); // Sets the found room to the booking.
            booking.setCustomer(customer); // Sets the found customer to the booking.
            bookingService.saveBooking(booking); // Saves the new booking with the room and customer.
        }
        return "redirect:/bookings"; // Redirects back to the bookings page to show the updated list.
    }

    // Example method to show how a service booking might be handled.
    @GetMapping("/service")
    public String servicesBooking(Model model) {
        return "/services"; // Returns the Thymeleaf template name for booking services.
    }
}
