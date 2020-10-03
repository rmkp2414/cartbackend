package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.CategorySubType;
import com.manuja.shoppingapp.entity.CategoryType;
import com.manuja.shoppingapp.service.CategorySubTypeService;
import com.manuja.shoppingapp.service.CategoryTypeService;
import com.manuja.shoppingapp.service.CategoryTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategorySubTypeController {
    @Autowired
    CategorySubTypeService categorySubTypeService;

    @Autowired
    CategoryTypeService categoryTypeService;

//    @RequestMapping( value="/categorysubtype" , method = RequestMethod.GET)
//    public String loadCategorySubTypeForm(ModelMap modelMap){
//        //making a new instance of the entity category
//        CategorySubType categorySubType = new CategorySubType();
//        //assigning the entity instance to the modelmap object
//        modelMap.addAttribute("categorySubTypeObj",categorySubType);
//        //calling method in repository
//        List<CategorySubType> categorySubTypeList = categorySubTypeService.findAll();
//        //adding the list to model map
//        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
//
//        List<CategoryType> categoryList = categoryTypeService.findAll();
//        modelMap.addAttribute("categoryList",categoryList);
//
//        modelMap.addAttribute("saveFlag",true);
//
//        //returning the jsp page
//        return "CategorySubType";
//
//    }
//
//    @RequestMapping(value = "/categorysubtype", method = RequestMethod.POST)
//    public String addCategorySubType(CategorySubType categorySubType,ModelMap modelMap){
//
//        categorySubTypeService.Save(categorySubType);
//        CategorySubType categorySubType1 = new CategorySubType();
//        modelMap.addAttribute("categorySubTypeObj",categorySubType1);
//
//        List<CategoryType> categoryList = categoryTypeService.findAll();
//        modelMap.addAttribute("categoryList",categoryList);
//
//        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
//        //adding the list to model map
//        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
//
//        modelMap.addAttribute("saveFlag",true);
//
//        return "CategorySubType";
//    }
//
//
//    @RequestMapping(value = "/editcategorysubtype-{id}",method = RequestMethod.GET)
//    public  String editCategorySubType(@PathVariable String id, ModelMap modelMap){
//        Integer intID = Integer.parseInt(id);
//        CategorySubType categorySubType = categorySubTypeService.findById(intID);
//        modelMap.addAttribute("categorySubTypeObj",categorySubType);
//
//        List<CategorySubType>catsubList = categorySubTypeService.findAll();
//        modelMap.addAttribute("categorySubTypeList",catsubList);
//
//        List<CategoryType> categoryList = categoryTypeService.findAll();
//        modelMap.addAttribute("categoryList",categoryList);
//
//        modelMap.addAttribute("saveFlag",false);
//
//        return "CategorySubType";
//    }
//
//    @RequestMapping(value = "/editcategorysubtype-{id}",method = RequestMethod.POST)
//    public String UpdateCategorySubType(CategorySubType categorySubType,@PathVariable String id, ModelMap modelMap){
//
//        categorySubTypeService.Update(categorySubType);
//
//        CategorySubType categorySubType1 = new CategorySubType();
//        modelMap.addAttribute("categorySubTypeObj",categorySubType1);
//
//        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
//        //adding the list to model map
//        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
//
//        List<CategoryType> categoryList = categoryTypeService.findAll();
//        modelMap.addAttribute("categoryList",categoryList);
//
//
//        modelMap.addAttribute("saveFlag",true);
//
//        return "CategorySubType";
//    }
//    @RequestMapping(value = "/deletecategorysubtype-{id}",method = RequestMethod.GET)
//    public String DeleteCategorySubType(@PathVariable  String id, ModelMap modelMap){
//        Integer ID= Integer.parseInt(id);
//        CategorySubType categorySubType = categorySubTypeService.findById(ID);
//        categorySubTypeService.Delete(categorySubType);
//        //creating a new entity to create a new object
//        CategorySubType categorySubType1 = new CategorySubType();
//        modelMap.addAttribute("categorySubTypeObj",categorySubType1);
//
//        List<CategorySubType>categorySubTypeList = categorySubTypeService.findAll();
//        //adding the list to model map
//        modelMap.addAttribute("categorySubTypeList",categorySubTypeList);
//
//        List<CategoryType> categoryList = categoryTypeService.findAll();
//        modelMap.addAttribute("categoryList",categoryList);
//
//
//        modelMap.addAttribute("saveFlag",true);
//
//        return "CategorySubType";
//
//    }

}
