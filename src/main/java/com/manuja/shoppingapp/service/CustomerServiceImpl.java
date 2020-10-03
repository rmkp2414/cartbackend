package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Customer;
import com.manuja.shoppingapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void Save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void Update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void Delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(Integer id) {
       return  customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
