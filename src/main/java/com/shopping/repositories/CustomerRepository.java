package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
