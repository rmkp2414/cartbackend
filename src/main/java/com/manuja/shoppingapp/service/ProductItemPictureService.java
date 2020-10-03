package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.ProductItemPIcture;

import java.util.List;

public interface ProductItemPictureService {
    public void Save(ProductItemPIcture productItemPIcture);
    public void Update(ProductItemPIcture productItemPIcture);
    public void Delete(ProductItemPIcture productItemPIcture);
    public ProductItemPIcture FindById(Integer id);
    public List<ProductItemPIcture> FindAll();
}
