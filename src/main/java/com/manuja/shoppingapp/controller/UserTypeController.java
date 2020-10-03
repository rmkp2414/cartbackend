//package com.manuja.shoppingapp.controller;
//
//import com.manuja.shoppingapp.entity.SUserType;
//import com.manuja.shoppingapp.service.SUserTypeService;
//import org.hibernate.usertype.UserType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
//@Controller
//public class UserTypeController {
//    @Autowired
//    SUserTypeService userTypeService;
//
//    @RequestMapping(value = "/userType",method = RequestMethod.GET)
//    public String loadUserTypeForm(ModelMap modelMap){
//
//        SUserType userType = new SUserType();
//        modelMap.addAttribute("userTypeObj",userType);
//
//        List<SUserType> userTypeList = userTypeService.findAll();
//        modelMap.addAttribute("userTypeList",userTypeList);
//        modelMap.addAttribute("saveFlag",true);
//        //System.out.println("Load category type form function");
//        return "UserType";
//    }
//
//
//    @RequestMapping(value = "/userType",method = RequestMethod.POST)
//    public String saveUserType(SUserType userType, ModelMap modelMap){
//
//        userTypeService.Save(userType);
//
//        SUserType userType1 = new SUserType();
//
//        modelMap.addAttribute("userTypeObj",userType1);
//        List<SUserType>userTypeList = userTypeService.findAll();
//
//        modelMap.addAttribute("userTypeList",userTypeList);
//        modelMap.addAttribute("saveFlag",true);
//
//        return "UserType";
//
//    }
//    @RequestMapping(value = "/edit-susertype-{id}",method = RequestMethod.GET)
//    public String EditUserType(@PathVariable String id, ModelMap modelMap){
//        Integer Id = Integer.parseInt(id);
//        SUserType userType = userTypeService.findById(Id);
//        modelMap.addAttribute("userTypeObj",userType);
//
//        List<SUserType> userTypeList = userTypeService.findAll();
//
//        modelMap.addAttribute("userTypeList",userTypeList);
//        modelMap.addAttribute("SaveFlag",false);
//        return  "UserType";
//
//    }
//    @RequestMapping(value = "/edit-susertype-{id}",method = RequestMethod.POST)
//    public String UpdateUserType(SUserType sUserType,@PathVariable String id,ModelMap modelMap){
//        userTypeService.Update(sUserType);
//
//        SUserType userType = new SUserType();
//        modelMap.addAttribute("userTypeObj",userType);
//
//        List<SUserType> userTypeList = userTypeService.findAll();
//
//        modelMap.addAttribute("userTypeList",userTypeList);
//        modelMap.addAttribute("SaveFlag",true);
//        return  "UserType";
//    }
//    @RequestMapping(value = "/delete-usertype-{id}",method = RequestMethod.GET)
//    public String DeleteUserType(@PathVariable String id, ModelMap modelMap){
//        Integer Id=Integer.parseInt(id);
//        SUserType userType = userTypeService.findById(Id);
//        userTypeService.Delete(userType);
//
//        SUserType userType1 = new SUserType();
//        modelMap.addAttribute("userTypeObj",userType1);
//        List<SUserType> userTypeList = userTypeService.findAll();
//
//        modelMap.addAttribute("userTypeList",userTypeList);
//        modelMap.addAttribute("SaveFlag",true);
//        return  "UserType";
//    }
//}
//
