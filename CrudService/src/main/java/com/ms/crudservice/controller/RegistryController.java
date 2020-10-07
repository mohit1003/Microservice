package com.ms.crudservice.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.crudservice.dao.PaymentRepo;
import com.ms.crudservice.dao.RegistryRepo;
import com.ms.crudservice.model.Customer;
import com.ms.crudservice.model.Payment;

@RestController
public class RegistryController {
	
	@Autowired
	private RegistryRepo _custRepo;
	@Autowired
	private PaymentRepo _paymentRepo;
	
	@PostMapping(path="/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer) {
		return _custRepo.save(customer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		return _custRepo.findAll();
	}


	@GetMapping("/customers/{id}")
	public Customer getAllCustomer(@PathVariable int id){
		return _custRepo.findByCustomerId(id);
	}
	
	@PutMapping("/modifyCustomer")
	public Customer modifyCustomer(@RequestBody Customer customer) {
		return _custRepo.save(customer);
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		_custRepo.deleteById(id);;
	}
	
	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody Payment pay) {
		return _paymentRepo.save(pay);
	}
	
	@GetMapping("/payments")
	public List<Payment> getAllPaymentsr(){
		return _paymentRepo.findAll();
	}
	
	@GetMapping("payment/{id}")
	public Payment getPayment(@PathVariable int id){
		return _paymentRepo.findByPaymentId(id);
	}
	
	@PutMapping("/editpayment")
	public Payment modifyPayment(@RequestBody Payment pay) {
		return _paymentRepo.save(pay);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByPaymentId(@PathVariable int id) {
		 _paymentRepo.deleteById(id);
	}
	
	@GetMapping("/payment-for-customer/{custId}")
	public List<Payment> getPaymentByCustomerId(@PathVariable int custId){
		return _paymentRepo.findBycustomerId(custId);
	}
	

}
