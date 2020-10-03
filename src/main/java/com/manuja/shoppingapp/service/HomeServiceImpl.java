package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Override
    public void saveUser(String name, String password, String rePassword) {
        logger.info("user creating with name: " +name);
       User user = new User();
       user.setUserType("customer");
      if (password.equals(rePassword)){
            userService.Save(user);
            logger.info("user created");
        }
      else {
          logger.info("Username and Password incorrect");

      }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Boolean isUserExist(String username, String Password) {
        User user = userRepository.findOneByUsername(username);
        if (user.getPassword().equals(Password)){
            return true;
        }
        else {
            return  false;
        }

    }
}
