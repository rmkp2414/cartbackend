package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
    User findOneByUsername(String username);
    
    Optional<User> findByUsername(String username);
    
    
    
}
