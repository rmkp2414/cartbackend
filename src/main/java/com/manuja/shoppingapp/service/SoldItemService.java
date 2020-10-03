package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.SoldItem;

import java.util.List;

public interface SoldItemService {
    public void Save(SoldItem soldItem);
    public void Update(SoldItem soldItem);
    public void Delete(SoldItem soldItem);
    public SoldItem FindById(Integer id);
    public List<SoldItem> FindAll();
}
