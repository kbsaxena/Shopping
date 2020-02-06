package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.LineItem;

public interface AccountRepository extends CrudRepository<LineItem, Long> {}
