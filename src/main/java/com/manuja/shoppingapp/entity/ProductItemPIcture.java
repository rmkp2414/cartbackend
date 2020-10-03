package com.manuja.shoppingapp.entity;

import javax.persistence.*;

@Entity @Table(name = "product_item_image")
public class ProductItemPIcture {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "picture")
    private String Picture;
    
    @Column(name = "path")
    private String path;
    
    @ManyToOne 
    @JoinColumn(name="product_itemid", referencedColumnName="id")
    private Product productItemId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Product getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Product productItemId) {
		this.productItemId = productItemId;
	}

}
