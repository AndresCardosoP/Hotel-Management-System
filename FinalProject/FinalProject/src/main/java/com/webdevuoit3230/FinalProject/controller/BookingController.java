package com.webdevuoit3230.FinalProject.controller;

import com.webdevuoit3230.FinalProject.model.Booking;
import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.service.BookingService;
import com.webdevuoit3230.FinalProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAllBookings());
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("rooms", roomService.findAllRooms());
        return "bookings";
    }

    @PostMapping
    public String addBooking(@ModelAttribute("newBooking") Booking booking, @RequestParam Long roomId) {
        Room room = roomService.findRoomById(roomId);
        if (room != null) {
            booking.setRoom(room);
            bookingService.saveBooking(booking);
        }
        return "redirect:/bookings";
    }
    
    @GetMapping("/service")
    public String servicesBooking(Model model) {
    	return "/services";
    }
}
