package com.manuja.shoppingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cart_item")
public class CartItem {
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    
    @ManyToOne 
    @JoinColumn(name="cart_id", referencedColumnName="id")
    private Cart cart;
    
    @ManyToOne 
    @JoinColumn(name="product_id", referencedColumnName="id")
    private Product product;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "size")
    private String size;
    
    @Column(name = "sold_price")
    private String soldPrice;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(String soldPrice) {
		this.soldPrice = soldPrice;
	}

	
    
}
