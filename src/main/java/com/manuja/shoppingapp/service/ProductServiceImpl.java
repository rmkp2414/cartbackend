package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.CategoryType;
import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.repository.CategoryTypeRepository;
import com.manuja.shoppingapp.repository.ProductItemPictureRepository;
import com.manuja.shoppingapp.repository.ProductRepository;
import com.manuja.shoppingapp.util.StatusMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
    ProductRepository productRepository;
	
	@Autowired
	CategoryTypeRepository categoryTypeRepository;
	
	@Autowired
	private ProductItemPictureRepository productItemPictureRepository;
	
    @Override
    public void Save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void Update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void Delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product FindById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

	@Override
	public ResponseDto getProductById(String id) {
		int productId = 0;
		
		ResponseDto responseDto = new ResponseDto();
		
		try{
			productId = Integer.parseInt(id);
		}catch(Exception e) {
			//Can not parse id
		}
		if(productId != 0) {
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()) {
				Product myProduct = product.get();
				ProductDetailsDto productDetailsDto = convertProductToDto(myProduct);
				responseDto.setStatus(true);
				responseDto.setData(productDetailsDto);
				
				return responseDto;
				
			}else {
				responseDto.setStatus(false);
				responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
				responseDto.setData(null);
				
				return responseDto;
			}
			
			
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
			responseDto.setData(null);
			
			return responseDto;
		}
	}

	@Override
	public List<ProductDetailsDto> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDetailsDto> productDetailsDtos = new ArrayList<ProductDetailsDto>();
		for (Product product : products) {
			ProductDetailsDto productDetailsDto = convertProductToDto(product);
			productDetailsDtos.add(productDetailsDto);
		}
		return productDetailsDtos;
	}
	
	@Override
	public ProductDetailsDto convertProductToDto(Product myProduct) {
		if(myProduct != null) {
			ProductDetailsDto productDetailsDto = new ProductDetailsDto();
			productDetailsDto.setName(myProduct.getName());
			if(myProduct.getCategoryType() != null) {
				productDetailsDto.setCategory(myProduct.getCategoryType().getCategoryType());
				productDetailsDto.setCategoryId(myProduct.getCategoryType().getId());
			}
			productDetailsDto.setDescription(myProduct.getDescription());
			productDetailsDto.setPrice(myProduct.getPrice());
			
			double number = Double.parseDouble(myProduct.getPrice()) ; // you have this
			int decimal = (int) number; // you have 12345
			double fractional = number - decimal; // you have 0.6789
					
					
			productDetailsDto.setPriceWithoutFraction(decimal + "");
			productDetailsDto.setPriceFraction("00");
//			List<String> images = new ArrayList<String>(); /** add ptoduct image urls**/
			List<String> images = productItemPictureRepository.getProductItemPIctureNameList(myProduct.getId());
//			images.add("images/product_image_1.jpg");
//			images.add("images/product_image_1.jpg");
//			if(images.size() == 0) {
//				List<String> startImages = new ArrayList<String>();
//				startImages.add("images/product_image_1.jpg");
//				productDetailsDto.setImages(startImages);
//			} else {
//				
//			}
			productDetailsDto.setImages(images);
			productDetailsDto.setRating(myProduct.getRating());
			
			Map<String, Boolean> sizes = new LinkedHashMap<String, Boolean>();
			sizes.put("XS", true);
			sizes.put("S", true);
			sizes.put("M", true);
			sizes.put("L", true);
			sizes.put("XL", false);
			sizes.put("XXL", false);
			productDetailsDto.setSizes(sizes);
			productDetailsDto.setId(myProduct.getId().toString());
			return productDetailsDto;
		}else {
			return null;
		}
		
	}
	
	private Product convertDtoToProduct(ProductDetailsDto productDetailsDto) {
		Product product = new Product();
		
		product.setName(productDetailsDto.getName());
		product.setDescription(productDetailsDto.getDescription());
		product.setPrice(productDetailsDto.getPrice());
		product.setRating(productDetailsDto.getRating());
		product.setSizes("");
		
		return product;
		
	}

	@Override
	public ResponseDto createProduct(ProductDetailsDto productDetailsDto) {
		Product product =  convertDtoToProduct(productDetailsDto);
		
		int categoryId = 1;
		if(productDetailsDto.getCategory() != null && !productDetailsDto.getCategory().isEmpty()) {
			categoryId = Integer.parseInt(productDetailsDto.getCategory());
		}
		
		Optional<CategoryType> categoryType = categoryTypeRepository.findById(categoryId);
		if(categoryType.isPresent()) {
			product.setCategoryType(categoryType.get());
		}else {
			List<CategoryType> categories = categoryTypeRepository.findAll();
			if(categories.size() > 0) {
				product.setCategoryType(categories.get(0));
			}
		}
		Product createdProduct = productRepository.save(product);
		ResponseDto responseDto = new ResponseDto();
		if(createdProduct != null) {
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
			ProductDetailsDto productDetailsDtoUpdated = convertProductToDto(createdProduct);
			responseDto.setData(productDetailsDtoUpdated);
			return responseDto;
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_CREATION_FAILED.getStatusMessage());
			return responseDto;
		}
		
	}

	@Override
	public ResponseDto updateProduct(ProductDetailsDto productDetailsDto) {
		int productId = 0;
		
		ResponseDto responseDto = new ResponseDto();
		
		try{
			productId = Integer.parseInt(productDetailsDto.getId());
		}catch(Exception e) {
			//Can not parse id
		}
		if(productId != 0 && productDetailsDto != null) {
			Optional<Product> product = productRepository.findById(productId);
			if(product.isPresent()) {
				Product myProduct = product.get();
				
				if(productDetailsDto.getName() != null && !productDetailsDto.getName().isEmpty()) {
					myProduct.setName(productDetailsDto.getName());
				}
				
				if(productDetailsDto.getDescription() != null && !productDetailsDto.getDescription().isEmpty()) {
					myProduct.setDescription(productDetailsDto.getDescription()); 
				}
				
				if(productDetailsDto.getPrice() != null && !productDetailsDto.getPrice().isEmpty()) {
					myProduct.setPrice(productDetailsDto.getPrice());
				}
				
				if(productDetailsDto.getRating() != null && !productDetailsDto.getRating().isEmpty()) {
					myProduct.setRating(productDetailsDto.getRating());
				}
				
				if(productDetailsDto.getCategoryId() != null && productDetailsDto.getCategoryId() > 0) {
					Optional<CategoryType> categoryUpdated = categoryTypeRepository.findById(productDetailsDto.getCategoryId());
					myProduct.setCategoryType(categoryUpdated.get()); 
				}
				
				Product updatedProduct = productRepository.save(myProduct);
				
				productDetailsDto = convertProductToDto(updatedProduct);
				responseDto.setStatus(true);
				responseDto.setData(productDetailsDto);
				
				return responseDto;
				
			}else {
				responseDto.setStatus(false);
				responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
				responseDto.setData(null);
				
				return responseDto;
			}
			
			
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
			responseDto.setData(null);
			
			return responseDto;
		}
	}

	@Override
	public ResponseDto deleteProduct(Integer id) {
		ResponseDto responseDto = new ResponseDto();
		if(id != null && id != 0) {
			productRepository.deleteById(id);
			responseDto.setStatus(true);
			responseDto.setData(null);
			responseDto.setStatusMessage(StatusMessages.ITEM_DELETED.getStatusMessage());
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
			responseDto.setData(null);
		}
		return responseDto;
	}
}
