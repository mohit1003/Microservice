package com.ms.crudservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.crudservice.model.Customer;

public interface RegistryRepo extends JpaRepository<Customer, Integer> {

	public Customer findByCustomerId(int id);
	public String deleteByCustomerId(int id);
}
