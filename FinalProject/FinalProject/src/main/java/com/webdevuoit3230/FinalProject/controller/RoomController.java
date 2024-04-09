package com.webdevuoit3230.FinalProject.controller;

// Imports for model handling, service layer interaction, and Spring MVC annotations
import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Controller to handle room-related web requests
@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    // Injecting the room service to interact with room data
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Show all rooms and a form to add a new room
    @GetMapping
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms()); // Adds list of rooms to model
        model.addAttribute("newRoom", new Room()); // Adds a new Room object for form binding
        return "rooms"; // Points to `rooms.html` Thymeleaf template
    }

    // Processes the form submission for adding a new room
    @PostMapping
    public String addRoom(@ModelAttribute("newRoom") Room room, Model model) {
        try {
            roomService.saveRoom(room); // Attempt to save the new room
        } catch (IllegalArgumentException e) {
            // If an error occurs, return to the rooms page with an error message
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("newRoom", room);
            model.addAttribute("errorMessage", e.getMessage());
            return "rooms";
        }
        return "redirect:/rooms"; // Redirect back to the rooms list page
    }

    // A placeholder for services page redirection (Example usage)
    @GetMapping("/services")
    public String GetServices(Model model) {
        return "services"; // Points to `services.html`
    }

    // Updates the availability status of a room
    @GetMapping("/updateAvailability/{roomId}")
    public String updateRoomAvailability(@PathVariable Long roomId, @RequestParam boolean isAvailable) {
        Room room = roomService.findRoomById(roomId); // Find the room by ID
        if (room != null) {
            room.setAvailable(isAvailable); // Set the room's availability
            roomService.saveRoom(room); // Save the updated room
        }
        return "redirect:/rooms"; // Redirect back to the room list page
    }
}
