package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.ProductItemPIcture;
import com.manuja.shoppingapp.repository.ProductItemPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemPictureServiceImpl implements ProductItemPictureService {
    @Autowired
    ProductItemPictureRepository productItemPictureRepository;
    @Override
    public void Save(ProductItemPIcture productItemPIcture) {
        productItemPictureRepository.save(productItemPIcture);
    }

    @Override
    public void Update(ProductItemPIcture productItemPIcture) {
        productItemPictureRepository.save(productItemPIcture);
    }

    @Override
    public void Delete(ProductItemPIcture productItemPIcture) {
        productItemPictureRepository.delete(productItemPIcture);
    }

    @Override
    public ProductItemPIcture FindById(Integer id) {
        return productItemPictureRepository.findById(id).get();
    }

    @Override
    public List<ProductItemPIcture> FindAll() {
        return productItemPictureRepository.findAll();
    }
}
