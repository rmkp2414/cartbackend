package com.manuja.shoppingapp.repository;

import com.manuja.shoppingapp.entity.ProductItemPIcture;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemPictureRepository extends JpaRepository<ProductItemPIcture,Integer> {
	
	@Query(value = "SELECT * FROM product_item_image WHERE product_itemid=?1", nativeQuery = true)
	List<ProductItemPIcture> getProductItemPIctureList(int product_itemid);
	
	@Query(value = "SELECT picture FROM product_item_image WHERE product_itemid=?1", nativeQuery = true)
	List<String> getProductItemPIctureNameList(int product_itemid);
	
	@Query(value = "DELETE FROM product_item_image WHERE id= ?1", nativeQuery = true)
	void deleteImageByImageName(int id);
	
	@Transactional
    @Modifying
	@Query(value = "UPDATE product_item_image SET picture=?1 WHERE id=?2", nativeQuery = true)
	void updatePasswordById(String picture ,long id);
	
}
