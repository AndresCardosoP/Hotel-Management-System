package com.webdevuoit3230.FinalProject.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Marks the class as a JPA entity.
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy.
    private Long id;

    @ManyToOne // Many-to-One relationship with Room.
    @JoinColumn(name = "room_id") // Specifies the column for joining with the Room entity.
    private Room room;

    @ManyToOne // Many-to-One relationship with Customer.
    @JoinColumn(name = "customer_id") // Specifies the column for joining with the Customer entity.
    private Customer customer;

    private LocalDate startDate; // Booking start date.
    private LocalDate endDate; // Booking end date.

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
