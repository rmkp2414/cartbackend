package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.ProductItem;

import java.util.List;

public interface ProductItemService {
    public void Save(ProductItem productItem);
    public void Update(ProductItem productItem);
    public void Delete(ProductItem productItem);
    public ProductItem FindById(Integer id);
    public List<ProductItem>FindAll();
}
