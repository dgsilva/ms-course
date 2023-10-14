package com.api.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.payroll.entities.Payment;
import com.api.payroll.entities.Worker;
import com.api.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentServices {

	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public  Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}
}
