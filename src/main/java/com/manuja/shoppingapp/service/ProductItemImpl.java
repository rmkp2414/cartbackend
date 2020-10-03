package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.ProductItem;
import com.manuja.shoppingapp.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductItemImpl implements ProductItemService{
    @Autowired
    ProductItemRepository productItemRepository;
    @Override
    public void Save(ProductItem productItem) {
        productItemRepository.save(productItem);
    }

    @Override
    public void Update(ProductItem productItem) {
        productItemRepository.save(productItem);
    }

    @Override
    public void Delete(ProductItem productItem) {
        productItemRepository.delete(productItem);
    }

    @Override
    public ProductItem FindById(Integer id) {
        return productItemRepository.findById(id).get();
    }

    @Override
    public List<ProductItem> FindAll() {
        return productItemRepository.findAll();
    }
}
