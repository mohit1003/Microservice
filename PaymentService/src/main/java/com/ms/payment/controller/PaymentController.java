package com.ms.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.payment.model.Payment;


@RestController
public class PaymentController {
	
	@Autowired
	RestTemplate rest;
	@PostMapping("/addPayment")
	public String addPayment(@RequestBody Payment pay) {
//		return rest.postForObject("http://localhost:8080/payment/addPayment", pay, Payment.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Payment> request = new HttpEntity<>(pay, headers);
		return rest.exchange("http://localhost:8080/payment/addPayment", HttpMethod.POST, request, new ParameterizedTypeReference<Payment>() { }).toString();
	}
	
	@GetMapping("/payments")
	public String getAllPaymentsr(){
		return rest.exchange("http://localhost:8080/payment/payments", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();
	}
	
	@GetMapping("payment/{id}")
	public Payment getPayment(@PathVariable int id){
		return rest.getForObject("http://localhost:8080/payment/payment/{id}", Payment.class, id);
	}
	
	@PutMapping("/editpayment")
	public void modifyPayment(@RequestBody Payment pay) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Payment> request = new HttpEntity<>(pay, headers);
		 rest.put("http://localhost:8080/payment/editpayment", request);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByPaymentId(@PathVariable int id) {
		rest.delete("http://localhost:8080/payment/delete/{id}",id);
	}
	
	@GetMapping("/payment-for-customer/{custId}")
	public String getPaymentByCustomerId(@PathVariable int custId){
		return rest.exchange("http://localhost:8080/payment/payment-for-customer/{custId}",HttpMethod.GET, null,
				new  ParameterizedTypeReference<String>() {
		}, custId).getBody();
	}

}
