package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {}
