package com.ms.crudservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ms.crudservice.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	public Payment findByPaymentId(int id);
	public String deleteByPaymentId(int id);
	
	@Query(value="SELECT * FROM Payment WHERE Payment.customerId = ?1",nativeQuery = true )
	public List<Payment> findBycustomerId(int custId);
}
