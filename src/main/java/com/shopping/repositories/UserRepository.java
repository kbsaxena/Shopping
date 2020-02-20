package com.shopping.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shopping.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	@Query("select new com.shopping.entities.User(u.username, u.password, u.id) from User u, Customer c where u.customer.id = c.id and c.email = ?1")
	User userCustomerData(String email);
}
