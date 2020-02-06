package com.shopping.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
