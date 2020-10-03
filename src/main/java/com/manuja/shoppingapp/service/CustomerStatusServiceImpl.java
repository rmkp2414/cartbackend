package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CustomerStatus;
import com.manuja.shoppingapp.repository.CustomerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerStatusServiceImpl implements CustomerStatusService{
    @Autowired
    CustomerStatusRepository customerStatusRepository;
    @Override
    public void Save(CustomerStatus customerStatus) {
        customerStatusRepository.save(customerStatus);
    }

    @Override
    public void Update(CustomerStatus customerStatus) {
        customerStatusRepository.save(customerStatus);
    }

    @Override
    public void Delete(CustomerStatus customerStatus) {
        customerStatusRepository.delete(customerStatus);
    }

    @Override
    public CustomerStatus findById(Integer id) {
        return customerStatusRepository.findById(id).get();
    }

    @Override
    public List<CustomerStatus> findAll() {
        return customerStatusRepository.findAll();
    }
}
