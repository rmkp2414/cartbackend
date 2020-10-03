package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CustomerStatus;

import java.util.List;

public interface CustomerStatusService {
    public void Save(CustomerStatus customerStatus);
    public  void Update (CustomerStatus customerStatus);
    public void Delete(CustomerStatus customerStatus);
    public  CustomerStatus findById(Integer id);
    public List<CustomerStatus>findAll();
}
