package com.manuja.shoppingapp.entity;

import javax.persistence.*;

@Entity @Table(name = "customer_status")
public class CustomerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @Column(name = "active_deact")
    private boolean activeStatus;

    public CustomerStatus() {
    }

    @Override
    public String toString() {
        return "CustomerStatus{" +
                "id=" + id +
                ", customer=" + customer +
                ", activeStatus=" + activeStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
