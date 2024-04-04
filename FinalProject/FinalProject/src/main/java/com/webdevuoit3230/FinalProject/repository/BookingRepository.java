package com.webdevuoit3230.FinalProject.repository;

import com.webdevuoit3230.FinalProject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // You can add more methods here if necessary
}
