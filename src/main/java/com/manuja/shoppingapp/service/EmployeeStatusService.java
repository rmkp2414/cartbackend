package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.EmployeeStatus;

import java.util.List;

public interface EmployeeStatusService {
    public void Save(EmployeeStatus employeeStatus);
    public  void Update (EmployeeStatus employeeStatus);
    public void Delete(EmployeeStatus employeeStatus);
    public  EmployeeStatus findById(Integer id);
    public List<EmployeeStatus> findAll();
}
//public void Save(CustomerStatus customerStatus);
