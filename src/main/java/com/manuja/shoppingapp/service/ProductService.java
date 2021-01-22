package com.manuja.shoppingapp.service;

import java.util.List;

import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.Product;

public interface ProductService {
    public void Save(Product product);
    public void Update(Product product);
    public void Delete(Product product);
    public  Product FindById(Integer id);
    public List<Product>findAll();
    
    //
	public ResponseDto getProductById(String id);
	public List<ProductDetailsDto> getAllProducts();
	public ResponseDto createProduct(ProductDetailsDto productDetailsDto);
	public ResponseDto updateProduct(ProductDetailsDto productDetailsDto);
	public ResponseDto deleteProduct(Integer id);
	public ProductDetailsDto convertProductToDto(Product myProduct);
	
	public List<ProductDetailsDto> getProductsByCategory(String category);
}
