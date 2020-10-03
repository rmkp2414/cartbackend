package com.manuja.shoppingapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_sub_type")
public class CategorySubType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "sub_type_name")
    private String subTypeName;

//    @ManyToOne
//    @JoinColumn (name="categorytype_id")
//    private CategoryType categoryTypeObj;
//    @OneToMany(mappedBy = "categorySubTypeobj")
//    private List<Product>productList;

    public CategorySubType() {
    }

    @Override
    public String toString() {
        return subTypeName;
    }

//    public CategoryType getCategoryTypeObj() {
//        return categoryTypeObj;
//    }
//
//    public void setCategoryTypeObj(CategoryType categoryTypeObj) {
//        this.categoryTypeObj = categoryTypeObj;
//    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }
}
