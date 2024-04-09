package com.webdevuoit3230.FinalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity // Marks the class as a JPA entity.
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy.
    private Long id;
    private String roomNumber; // Room number.
    private String type; // Room type.
    private Double price; // Room price.
    private boolean isAvailable; // Availability status.

    @OneToMany(mappedBy = "room") // One-to-Many relationship with Booking.
    private List<Booking> bookings; // List of bookings for the room.

    // Constructors, Getters, and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
