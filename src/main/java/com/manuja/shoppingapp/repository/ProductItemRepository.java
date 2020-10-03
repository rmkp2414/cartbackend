package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem,Integer> {
}
