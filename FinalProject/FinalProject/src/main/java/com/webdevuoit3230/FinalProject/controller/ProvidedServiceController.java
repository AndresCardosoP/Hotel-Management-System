package com.webdevuoit3230.FinalProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webdevuoit3230.FinalProject.model.ProvidedService;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/service")
public class ProvidedServiceController {
	
	@GetMapping
	public String displayTaskForm()
	{
		return "services";
	}
}
