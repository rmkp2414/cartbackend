package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CompletedOrder;
import com.manuja.shoppingapp.repository.CompletedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompletedOrderServiceImpl implements CompletedOrderService {
    @Autowired
    CompletedOrderRepository completedOrderRepository;
    @Override
    public void Save(CompletedOrder completedOrder) {
        completedOrderRepository.save(completedOrder);
    }

    @Override
    public void Update(CompletedOrder completedOrder) {
        completedOrderRepository.save(completedOrder);
    }

    @Override
    public void Delete(CompletedOrder completedOrder) {
        completedOrderRepository.delete(completedOrder);
    }

    @Override
    public CompletedOrder FindById(Integer id) {
        return completedOrderRepository.findById(id).get();
    }

    @Override
    public List<CompletedOrder> FindAll() {
         return completedOrderRepository.findAll();
    }
}
