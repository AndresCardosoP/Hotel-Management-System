package com.webdevuoit3230.FinalProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.model.Task;
import com.webdevuoit3230.FinalProject.service.CustomerService;

import jakarta.servlet.http.HttpSession;

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

    @PostMapping
    public String addCustomer(@RequestParam("name") String name,
                              @RequestParam("phoneNumber") String phoneNumber,
                              @RequestParam("email") String email,
                              HttpSession session) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
        if (customerList == null) {
        	customerList = new ArrayList<>();
        }
        customerList.add(customer);
        session.setAttribute("customerList", customerList);
        
        return "redirect:/customers/rooms";
    }
	
    @GetMapping("/rooms")
    public String displayHomePage(HttpSession session) {
    	List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
        if (customerList == null || customerList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
        	for (Customer customer : customerList) {
        	    System.out.println("Customer Name: " + customer.getName());
        	    System.out.println("Customer Phone Number: " + customer.getPhoneNumber());
        	    System.out.println("Customer Email: " + customer.getEmail());
        	}
        }
        return "rooms"; 
    }
    
    @GetMapping("/home")
    public String displayCustomerpage() {
    	return "homepage";
    }
}
