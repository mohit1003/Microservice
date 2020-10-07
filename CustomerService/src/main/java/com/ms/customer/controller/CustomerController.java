package com.ms.customer.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.customer.model.Customer;
@RestController
@RequestMapping(name = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CustomerController {
	@Autowired
	RestTemplate rest;
	@PostMapping(path="/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
//		return rest.postForObject("http://localhost:8080/customer/addCustomer", customer, Customer.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
		return rest.postForObject("http://localhost:8762/addCustomer", request, Customer.class);
//		return rest.exchange("http://CRUDSERVICE/addCustomer", HttpMethod.POST, request, new ParameterizedTypeReference<Customer>() { }).toString();
	
	}
	
	@GetMapping("/customers")
	public String getAllCustomer(){
		return rest.exchange("http://CRUDSERVICE/customers", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();
	}
	

	@GetMapping("/customers/{id}")
	public Customer getAllCustomer(@PathVariable int id){
		return rest.getForObject("http://localhost:8080/customer/customers/{id}", Customer.class, id);
//		return rest.exchange("http://localhost:8080/customer/customer/{id}", HttpMethod.GET, null,
//				new ParameterizedTypeReference<String>() {
//				}, id).getBody();
	}
	
	@PutMapping("/modifyCustomer")
	public void modifyCustomer(@RequestBody Customer customer) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
		 rest.put("http://localhost:8080/customer/modifyCustomer", request);
		 
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		rest.delete("http://localhost:8080/customer/removeCustomer/{id}", id);
	}

}
