package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Price;

public interface PriceRepository extends CrudRepository<Price, Long> {}
