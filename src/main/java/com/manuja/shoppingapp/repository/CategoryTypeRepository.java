package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType,Integer> {

}
