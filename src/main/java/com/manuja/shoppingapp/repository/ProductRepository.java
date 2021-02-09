package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.Product;

import java.awt.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	java.util.List<Product>findAllByCategoryType(String categoryType);

}
