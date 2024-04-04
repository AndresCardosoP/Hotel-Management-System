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

@Controller
@RequestMapping("/bookings")
public class BookingController {
    
    private final BookingService bookingService;
    private final RoomService roomService;
    private final CustomerService customerService;

    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.customerService = customerService;
    }

    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAllBookings());
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "bookings"; // The Thymeleaf template for listing and adding bookings
    }

    @PostMapping
    public String addBooking(@ModelAttribute("newBooking") Booking booking, 
                             @RequestParam Long roomId, 
                             @RequestParam Long customerId) {
        Room room = roomService.findRoomById(roomId);
        Customer customer = customerService.findById(customerId);
        if (room != null && customer != null) {
            booking.setRoom(room);
            booking.setCustomer(customer);
            bookingService.saveBooking(booking);
        }
        return "redirect:/bookings"; // Redirect back to the bookings page after adding a booking
    }
<<<<<<< HEAD

    // Additional methods and logic as needed
=======
    
    @GetMapping("/service")
    public String servicesBooking(Model model) {
    	return "/services";
    }
>>>>>>> 98fe571310ddaeac80f1562a02411926a620a4a8
}
