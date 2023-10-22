package com.api.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.payroll.entities.Payment;
import com.api.payroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentServices service;
	@HystrixCommand(fallbackMethod = "findAllAlternativo" )
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findAll(@PathVariable Long workerId, @PathVariable Integer days) {
	 Payment payment = service.getPayment(workerId, days);
	 return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> findAllAlternativo(Long workerId, Integer days) {
		Payment payment = new Payment("Brann", 400.0, days);
		 return ResponseEntity.ok(payment);
	}
}
