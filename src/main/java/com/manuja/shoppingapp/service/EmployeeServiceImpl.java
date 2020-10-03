package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Employee;
import com.manuja.shoppingapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void Save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void Update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void Delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> FindAll() {
        return employeeRepository.findAll();
    }
}
