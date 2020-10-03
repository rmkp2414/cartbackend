package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CategorySubType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategorySubTypeService {
    public void Save(CategorySubType categorySubType);
    public void Update(CategorySubType categorySubType);
    public void Delete(CategorySubType categorySubType);
    public CategorySubType findById(Integer id);
    public List<CategorySubType> findAll();
}
