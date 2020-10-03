package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CompletedOrder;

import java.util.List;

public interface CompletedOrderService {
    public void Save(CompletedOrder completedOrder);
    public void Update(CompletedOrder completedOrder);
    public void Delete(CompletedOrder completedOrder);
    public CompletedOrder FindById(Integer id);
    public List<CompletedOrder>FindAll();
}
