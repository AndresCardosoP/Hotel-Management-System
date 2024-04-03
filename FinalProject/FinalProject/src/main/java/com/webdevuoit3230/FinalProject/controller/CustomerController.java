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
import org.springframework.web.bind.annotation.PathVariable;

import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.repository.CustomerRepository;
import com.webdevuoit3230.FinalProject.model.Task;
import com.webdevuoit3230.FinalProject.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String listCustomers(Model model) {
        //model.addAttribute("customers", customerService.getAllCustomers());
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

        // Save the customer to the repository
        Customer savedCustomer = customerRepository.save(customer);

        // Retrieve the list of customers from the session
        List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
        if (customerList == null) {
            customerList = new ArrayList<>();
        }
        

        
        // Add the customer to the list
        customerList.add(savedCustomer);
        

        // Update the session attribute
        session.setAttribute("customerList", customerList);

        return "redirect:/customers/successful/rooms";
    }

// Get Customer information from array
//  @GetMapping("/rooms")
//  public String displayHomePage(HttpSession session) {
//  	List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
//      if (customerList == null || customerList.isEmpty()) {
//          System.out.println("No tasks found.");
//      } else {
//      	for (Customer customer : customerList) {
//      	    System.out.println("Customer Name: " + customer.getName());
//      	    System.out.println("Customer Phone Number: " + customer.getPhoneNumber());
//      	    System.out.println("Customer Email: " + customer.getEmail());
//      	}
//      }
//      return "rooms"; 
//  }
  
    // Get customer information from database
    @GetMapping("/successful")
    public String getAllCustomers(Model model) {
        // Retrieve all customers from the repository
        Iterable<Customer> customers = customerRepository.findAll();
        
        // Iterate through each customer and print out their details
        for (Customer customer : customers) {
    	    System.out.println("Generated ID: " + customer.getId());
            System.out.println("Customer Name from Database: " + customer.getName());
            System.out.println("Customer phone number from Database: " + customer.getPhoneNumber());
            System.out.println("Customer email from Database: " + customer.getEmail());
        }
        
        return "rooms"; 
    }
    


    @GetMapping("/home")
    public String displayCustomerpage() {
        return "homepage";
    }
}