package com.webdevuoit3230.FinalProject.repository;

import com.webdevuoit3230.FinalProject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
