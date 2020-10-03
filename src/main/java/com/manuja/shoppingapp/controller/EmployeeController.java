package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.Employee;
import com.manuja.shoppingapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String loadEmployeeForm(ModelMap modelMap){
        Employee employee = new Employee();
        modelMap.addAttribute("employeeObject",employee);
        List<Employee> employeeList = employeeService.FindAll();

        modelMap.addAttribute("employeeList",employeeList);
        modelMap.addAttribute("saveFlag",true);

        return "Employee";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee, ModelMap modelMap){

        employeeService.Save(employee);

        Employee employee1 = new Employee();
        modelMap.addAttribute("employeeObject",employee1);
        List<Employee> employeeList = employeeService.FindAll();

        modelMap.addAttribute("employeeList",employeeList);
        modelMap.addAttribute("saveFlag",true);

        return "Employee";
    }
    @RequestMapping(value = "/edit-employee-{id}",method = RequestMethod.GET)
    public String editEmployee(@PathVariable String id, ModelMap modelMap){

        Integer Id = Integer.parseInt(id);
        Employee employee = employeeService.findById(Id);
        modelMap.addAttribute("employeeObject",employee);

        List<Employee>employeeList = employeeService.FindAll();
        modelMap.addAttribute("employeeList",employeeList);
        modelMap.addAttribute("saveFlag",false);
        return "Employee";
    }

    @RequestMapping(value = "/edit-employee-{id}",method = RequestMethod.POST)
    public String updateEmployee(@PathVariable String id,Employee employee, ModelMap modelMap){

        employeeService.Update(employee);

        Employee employee1 = new Employee();
        modelMap.addAttribute("employeeObject",employee1);

        List<Employee>employeeList = employeeService.FindAll();
        modelMap.addAttribute("employeeList",employeeList);

        modelMap.addAttribute("saveFlag",true);
        return "Employee";
    }
    @RequestMapping(value = "/delete-employee-{id}",method = RequestMethod.GET)
    public  String deleteEmployee(ModelMap modelMap, @PathVariable String id){
        Integer Id = Integer.parseInt(id);
        Employee employee = employeeService.findById(Id);
        employeeService.Delete(employee);

        Employee employee1 = new Employee();
        modelMap.addAttribute("employeeObject",employee1);

        List<Employee>employeeList = employeeService.FindAll();
        modelMap.addAttribute("employeeList",employeeList);

        modelMap.addAttribute("saveFlag",true);
        return "Employee";
    }
}
