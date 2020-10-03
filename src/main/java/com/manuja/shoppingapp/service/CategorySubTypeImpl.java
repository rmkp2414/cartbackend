package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CategorySubType;
import com.manuja.shoppingapp.repository.CategorySubTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorySubTypeImpl implements CategorySubTypeService{
    @Autowired
    private CategorySubTypeRepository categorySubTypeRepository;
    @Override
    public void Save(CategorySubType categorySubType) {
        categorySubTypeRepository.save(categorySubType);
    }

    @Override
    public void Update(CategorySubType categorySubType) {
        categorySubTypeRepository.save(categorySubType);
    }

    @Override
    public void Delete(CategorySubType categorySubType) {
        categorySubTypeRepository.delete(categorySubType);
    }

    @Override
    public CategorySubType findById(Integer id) {
        return categorySubTypeRepository.findById(id).get();
    }

    @Override
    public List<CategorySubType> findAll() {
      return   categorySubTypeRepository.findAll();
    }
}
