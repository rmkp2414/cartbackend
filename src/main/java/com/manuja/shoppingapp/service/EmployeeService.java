package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void Save(Employee employee);
    public void Update(Employee employee);
    public void Delete(Employee employee);
    public Employee findById(Integer id);
    public List<Employee>FindAll();
}
