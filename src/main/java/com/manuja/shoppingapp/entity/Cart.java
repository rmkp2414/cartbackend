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
@Table(name = "cart")
public class Cart {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne 
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "checkout")
    private boolean checkout;
    
    @Column(name = "totalAmount")
    private String totalAmount;
    
    @Column(name = "deliveryAddress")
    private String deliveryAddress;
    
    @Column(name = "referenceNumbebr")
    private String referenceNumbebr;
    
    @Column(name = "zipcode")
    private String zipcode;
    
    @Column(name = "contactNumber")
    private String contactNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getReferenceNumbebr() {
		return referenceNumbebr;
	}

	public void setReferenceNumbebr(String referenceNumbebr) {
		this.referenceNumbebr = referenceNumbebr;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
   
}
