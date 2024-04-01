package com.webdevuoit3230.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers"; // Refers to `customers.html`
	}

	@PostMapping("/addCustomer")
	public String addCustomer(Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
}
