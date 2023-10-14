package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Payment;
import com.api.services.PaymentServices;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentServices service;
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findAll(@PathVariable Long workerId, @PathVariable Integer days) {
	 Payment payment = service.getPayment(workerId, days);
	 return ResponseEntity.ok(payment);
	}
}
