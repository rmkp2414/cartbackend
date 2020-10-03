package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.CompletedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedOrderRepository extends JpaRepository<CompletedOrder,Integer> {
}
