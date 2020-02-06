package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {}
