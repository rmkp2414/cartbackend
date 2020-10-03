package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStatusRepository extends JpaRepository<CustomerStatus, Integer> {
}
