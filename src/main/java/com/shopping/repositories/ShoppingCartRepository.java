package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.LineItem;

public interface ShoppingCartRepository extends CrudRepository<LineItem, Long> {}
