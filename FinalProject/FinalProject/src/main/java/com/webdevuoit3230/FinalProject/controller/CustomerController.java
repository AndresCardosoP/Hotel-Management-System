package com.webdevuoit3230.FinalProject.controller;

// Standard imports for Spring MVC, models, and persistence
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.repository.CustomerRepository;

// Marks this class as a Spring MVC Controller handling requests for "/customers"
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    // Autowiring the customer repository to interact with customer data
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Displays the customer management page
    @GetMapping
    public String listCustomers(Model model) {
        // model.addAttribute("customers", customerService.getAllCustomers());
        return "customers"; // Refers to `customers.html` Thymeleaf template
    }

    // Handles the creation of a new customer via POST request
    @PostMapping
    public String addCustomer(@RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            HttpSession session) {
        Customer customer = new Customer(); // Create a new Customer instance
        customer.setName(name); // Set customer name
        customer.setPhoneNumber(phoneNumber); // Set customer phone number
        customer.setEmail(email); // Set customer email

        Customer savedCustomer = customerRepository.save(customer); // Save the customer to the repository

        // Retrieve the list of customers from the session, or initialize a new list if
        // none exists
        List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
        if (customerList == null) {
            customerList = new ArrayList<>();
        }

        customerList.add(savedCustomer); // Add the saved customer to the list

        session.setAttribute("customerList", customerList); // Update the session attribute with the new list

        return "redirect:/customers"; // Redirect back to the customers page
    }

    // Fetch and display all customer information from the database
    @GetMapping("/successful")
    public String getAllCustomers(Model model) {
        Iterable<Customer> customers = customerRepository.findAll(); // Retrieve all customers

        for (Customer customer : customers) {
            // Example of printing customer details to the console
            System.out.println("Generated ID: " + customer.getId());
            System.out.println("Customer Name from Database: " + customer.getName());
            System.out.println("Customer phone number from Database: " + customer.getPhoneNumber());
            System.out.println("Customer email from Database: " + customer.getEmail());
        }

        return "rooms"; // Redirects to the `rooms.html` Thymeleaf template
    }

    @GetMapping("/home")
    public String displayCustomerpage() {
        return "homepage"; // Directs to the homepage view
    }
}
