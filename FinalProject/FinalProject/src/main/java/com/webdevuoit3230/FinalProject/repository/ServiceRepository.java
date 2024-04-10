package com.webdevuoit3230.FinalProject.repository;

import com.webdevuoit3230.FinalProject.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ProvidedService, Long>{

}
