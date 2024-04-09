package com.webdevuoit3230.FinalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.repository.CustomerRepository;

import java.util.List;

@Service // Marks this class as a Spring service.
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired // Autowires the CustomerRepository.
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Methods for adding, finding, and retrieving customers.

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null); // This will return a customer or null if not found
    }
}
