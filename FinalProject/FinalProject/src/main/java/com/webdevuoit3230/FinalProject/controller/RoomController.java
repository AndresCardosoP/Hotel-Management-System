package com.webdevuoit3230.FinalProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webdevuoit3230.FinalProject.model.Room;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	
	@GetMapping
	public String displayRoompage()
	{
		return "rooms";
	}
	
    @GetMapping("/home")
    public String displayCustomerpage() {
    	return "homepage";
    }
}
