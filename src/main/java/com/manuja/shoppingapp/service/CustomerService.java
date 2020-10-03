package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void Save(Customer customer);
    public void Update(Customer customer);
    public void Delete(Customer customer);
    public Customer findById(Integer id);
    public List<Customer>findAll();
}
