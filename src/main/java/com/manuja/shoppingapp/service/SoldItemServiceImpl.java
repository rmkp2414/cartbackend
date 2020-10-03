package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.SoldItem;
import com.manuja.shoppingapp.repository.SoldItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoldItemServiceImpl implements SoldItemService {
    @Autowired
    SoldItemRepository soldItemRepository;
    @Override
    public void Save(SoldItem soldItem) {
        soldItemRepository.save(soldItem);
    }

    @Override
    public void Update(SoldItem soldItem) {
        soldItemRepository.save(soldItem);
    }

    @Override
    public void Delete(SoldItem soldItem) {
        soldItemRepository.delete(soldItem);
    }

    @Override
    public SoldItem FindById(Integer id) {
        return soldItemRepository.findById(id).get();
    }

    @Override
    public List<SoldItem> FindAll() {
        return soldItemRepository.findAll();
    }
}
