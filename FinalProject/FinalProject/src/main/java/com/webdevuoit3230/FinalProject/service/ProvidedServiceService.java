package com.webdevuoit3230.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevuoit3230.FinalProject.model.ProvidedService;
import com.webdevuoit3230.FinalProject.model.Customer;
import com.webdevuoit3230.FinalProject.repository.ServiceRepository;


@Service
public class ProvidedServiceService {
	
	private final ServiceRepository serviceRepository;
	
	@Autowired
	public ProvidedServiceService(ServiceRepository serviceRepository) {
	    this.serviceRepository = serviceRepository;
	}
	
	public List<ProvidedService> findAllServices() {
	    return serviceRepository.findAll();
	}
	
	public ProvidedService saveServices(ProvidedService services) {
	    return serviceRepository.save(services);
	}
	
	public ProvidedService findServicesById(Long id) {
	    return serviceRepository.findById(id).orElse(null);
	}
}
