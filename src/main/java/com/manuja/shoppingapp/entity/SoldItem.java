package com.manuja.shoppingapp.entity;

import javax.persistence.*;

@Entity @Table(name = "sold_item")
public class SoldItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "product_id")
    private Integer ProductItemId;
    //how to get productItemID, while it's not connected to product_item???????
    @Column(name = "quantity")
    private int Quantity;
    @ManyToOne @JoinColumn(name = "completed_order_id")
    private CompletedOrder completedOrderObj;

    public SoldItem() {
    }

    @Override
    public String toString() {
        return "SoldItem{" +
                "Id=" + Id +
                ", ProductItemId=" + ProductItemId +
                ", Quantity=" + Quantity +
                ", completedOrderObj=" + completedOrderObj +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public CompletedOrder getCompletedOrderObj() {
        return completedOrderObj;
    }

    public void setCompletedOrderObj(CompletedOrder completedOrderObj) {
        this.completedOrderObj = completedOrderObj;
    }

    public Integer getProductItemId() {
        return ProductItemId;
    }

    public void setProductItemId(Integer productItemId) {
        ProductItemId = productItemId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
