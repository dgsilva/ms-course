package com.api.services;

import org.springframework.stereotype.Service;

import com.api.entities.Payment;

@Service
public class PaymentServices {

	public  Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.00,days);
	}
}
