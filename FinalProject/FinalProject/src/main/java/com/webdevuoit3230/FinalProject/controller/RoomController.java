package com.webdevuoit3230.FinalProject.controller;

import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("newRoom", new Room());
        return "rooms";
    }

    @PostMapping
    public String addRoom(@ModelAttribute("newRoom") Room room, Model model) {
        try {
            roomService.saveRoom(room);
        } catch (IllegalArgumentException e) {
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("newRoom", room);
            model.addAttribute("errorMessage", e.getMessage());
            return "rooms";
        }
        return "redirect:/rooms";
    }

    @GetMapping("/services")
    public String GetServices(Model model) {
        return "services";
    }

    @GetMapping("/updateAvailability/{roomId}")
    public String updateRoomAvailability(@PathVariable Long roomId, @RequestParam boolean isAvailable) {
        Room room = roomService.findRoomById(roomId);
        if (room != null) {
            room.setAvailable(isAvailable);
            roomService.saveRoom(room);
        }
        return "redirect:/rooms";
    }
}
