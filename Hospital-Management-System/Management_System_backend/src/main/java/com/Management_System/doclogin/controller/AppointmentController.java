package com.Management_System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Management_System.doclogin.entity.Appointments;
import com.Management_System.doclogin.repository.AppointmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
	
	AppointmentRepository appointementRepository;

	public AppointmentController(AppointmentRepository appointementRepository) {
		super();
		this.appointementRepository = appointementRepository;
	}
	
	@PostMapping("/appointments")
	public Appointments createAppoitment (@RequestBody Appointments appointment) {
		
		return appointementRepository.save(appointment);
	}
	
	
	@GetMapping("/appointments")
	public List<Appointments> getAllAppointement() {
		
		return appointementRepository.findAll();
	}
	
	
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
		
		Appointments appointment = appointementRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("AppointMent Not Found With id"+ id));
		
		appointementRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	

}
