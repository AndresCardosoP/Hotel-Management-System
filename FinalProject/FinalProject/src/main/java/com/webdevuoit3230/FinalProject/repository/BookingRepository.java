package com.webdevuoit3230.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevuoit3230.FinalProject.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}

