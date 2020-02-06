package com.shopping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {}
