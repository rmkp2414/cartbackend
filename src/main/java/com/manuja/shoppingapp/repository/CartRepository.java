package com.manuja.shoppingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	List<Cart> findByUser(User user);
	
	List<Cart> findByUserAndStatusAndCheckout(User user, Boolean status, Boolean Checkout);
}
