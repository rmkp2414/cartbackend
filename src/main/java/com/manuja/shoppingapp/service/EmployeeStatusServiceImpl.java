package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.EmployeeStatus;
import com.manuja.shoppingapp.repository.EmployeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService{
    @Autowired
    EmployeeStatusRepository employeeStatusRepository;
    @Override
    public void Save(EmployeeStatus employeeStatus) {
        employeeStatusRepository.save(employeeStatus);
    }

    @Override
    public void Update(EmployeeStatus employeeStatus) {
        employeeStatusRepository.save(employeeStatus);
    }

    @Override
    public void Delete(EmployeeStatus employeeStatus) {
        employeeStatusRepository.delete(employeeStatus);
    }

    @Override
    public EmployeeStatus findById(Integer id) {
        return employeeStatusRepository.findById(id).get();
    }

    @Override
    public List<EmployeeStatus> findAll() {
        return employeeStatusRepository.findAll();
    }
}
