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
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("newRoom", new Room());
        return "rooms";
    }

    @PostMapping
    public String addRoom(@ModelAttribute("newRoom") Room room) {
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }
}
