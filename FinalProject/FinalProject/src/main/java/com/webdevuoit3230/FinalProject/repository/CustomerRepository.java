package com.webdevuoit3230.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdevuoit3230.FinalProject.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}