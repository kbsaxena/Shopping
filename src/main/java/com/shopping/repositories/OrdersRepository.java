package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long> {}
