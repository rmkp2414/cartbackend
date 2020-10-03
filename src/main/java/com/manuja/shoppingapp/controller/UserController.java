package com.manuja.shoppingapp.controller;

//import com.manuja.shoppingapp.entity.SUserType;
import com.manuja.shoppingapp.entity.User;
//import com.manuja.shoppingapp.service.SUserTypeService;
import com.manuja.shoppingapp.service.UserService;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

//    SUserTypeService sUserTypeService;

    @RequestMapping (value = "/user", method = RequestMethod.GET)
    public String loadUserForm(ModelMap modelMap){

        User user = new User();
        modelMap.addAttribute("userObj",user);

        List<User> userList = userService.findAll();
        modelMap.addAttribute("userList",userList);

////        List<SUserType> userTypeList = sUserTypeService.findAll();
//        modelMap.addAttribute("userTypeList",userTypeList);

        modelMap.addAttribute("saveFlag",true);
        //System.out.println("Load User  form function");
        return "User";
    }

    @RequestMapping (value = "/user", method = RequestMethod.POST)
    public String saveUser(User user, ModelMap modelMap){

        userService.Save(user);

        User userType1 = new User();

        modelMap.addAttribute("userObj",userType1);
        List<User>userList = userService.findAll();

        modelMap.addAttribute("userList",userList);
        modelMap.addAttribute("saveFlag",true);

//        List<SUserType> userTypeList = sUserTypeService.findAll();
//        modelMap.addAttribute("userTypeList",userTypeList);

        return "User";

    }
    @RequestMapping(value = "/edit-user-{id}" , method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model){

        Integer intId = Integer.parseInt(id);
        User user = userService.findById(intId);
        model.addAttribute("userObj",user);

        List<User> userList = userService.findAll();

        model.addAttribute("userList",userList);
        model.addAttribute("saveFlag",false);

//        List<SUserType> userTypeList = sUserTypeService.findAll();
//        model.addAttribute("userTypeList",userTypeList);

        return "User";
    }
    @RequestMapping(value = "/edit-user-{id}" , method = RequestMethod.POST)
    public String updateUser(User user,@PathVariable String id, ModelMap model){

        userService.Update(user);
        User user1 = new User();
                //setting Model
        model.addAttribute("userObj",user1);
        List<User> userList = userService.findAll();

        model.addAttribute("userList",userList);
        model.addAttribute("saveFlag",true);

//        List<SUserType> userTypeList = sUserTypeService.findAll();
//        model.addAttribute("userTypeList",userTypeList);

        return "User";
    }
    @RequestMapping(value = "/delete-user-{id}" , method = RequestMethod.GET)
    public String deleteCategoryType(@PathVariable String id, ModelMap model){

        Integer intId = Integer.parseInt(id);
        User user = userService.findById(intId);
        userService.Delete(user);

        User user1 = new User();
        //setting Model
        model.addAttribute("userObj",user1);
        List<User> userList = userService.findAll();

        model.addAttribute("userList",userList);
        model.addAttribute("saveFlag",true);

//        List<SUserType> userTypeList = sUserTypeService.findAll();
//        model.addAttribute("userTypeList",userTypeList);

        return "User";
    }
}
