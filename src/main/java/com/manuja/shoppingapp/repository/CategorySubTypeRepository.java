package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.CategorySubType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorySubTypeRepository extends JpaRepository<CategorySubType, Integer> {
}
