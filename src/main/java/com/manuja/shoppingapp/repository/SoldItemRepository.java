package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.SoldItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldItemRepository extends JpaRepository<SoldItem,Integer> {
}
