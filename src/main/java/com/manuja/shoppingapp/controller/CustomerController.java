package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.Customer;
import com.manuja.shoppingapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public String loadCustomer(ModelMap modelMap){

        Customer customer = new Customer();
        modelMap.addAttribute("customerObj",customer);

        List<Customer>customerList = customerService.findAll();
        modelMap.addAttribute("customerList",customerList);

        modelMap.addAttribute("saveFlag",true);
        return "Customer";
    }
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public String addCustomer(Customer customer, ModelMap modelMap){
        customerService.Save(customer);

        Customer customer1 = new Customer();
        modelMap.addAttribute("customerObj",customer1);

        List<Customer>customerList = customerService.findAll();
        modelMap.addAttribute("customerList",customerList);

        modelMap.addAttribute("saveFlag",true);
        return "Customer";
    }
    @RequestMapping(value = "/edit-customer-{id}" , method = RequestMethod.GET)
    public String editCustomer(@PathVariable String id, ModelMap modelMap){
        Integer Id = Integer.parseInt(id);
        Customer customer1 = customerService.findById(Id);
        modelMap.addAttribute("customerObj",customer1);

        List<Customer>customerList = customerService.findAll();
        modelMap.addAttribute("customerList",customerList);

        modelMap.addAttribute("saveFlag",false);
        return "Customer";

    }
    @RequestMapping(value = "/edit-customer-{id}" , method = RequestMethod.POST)
    public String updateCustomer(ModelMap modelMap, Customer customer){
        customerService.Update(customer);

        Customer customer1 = new Customer();
        modelMap.addAttribute("customerObj",customer1);

        List<Customer>customerList = customerService.findAll();
        modelMap.addAttribute("customerList",customerList);

        modelMap.addAttribute("saveFlag",true);
        return "Customer";
    }
    @RequestMapping(value = "/delete-customer-{id}" , method = RequestMethod.GET)
    public String deleteCustomer(ModelMap modelMap, @PathVariable String id){
        Integer Id = Integer.parseInt(id);
        Customer customer = customerService.findById(Id);
        customerService.Delete(customer);

        Customer customer1 = new Customer();
        modelMap.addAttribute("customerObj",customer1);

        List<Customer>customerList = customerService.findAll();
        modelMap.addAttribute("customerList",customerList);

        modelMap.addAttribute("saveFlag",true);
        return "Customer";
    }
}
