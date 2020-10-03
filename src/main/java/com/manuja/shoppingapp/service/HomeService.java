package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.User;

public interface HomeService {
    public void saveUser(String name, String password, String rePassword);
    public void updateUser(User user);

    public Boolean isUserExist(String username, String Password);
}
