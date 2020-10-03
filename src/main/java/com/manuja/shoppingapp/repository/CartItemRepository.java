package com.manuja.shoppingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
	
	List<CartItem> findByCart(Cart cart);
	
}
