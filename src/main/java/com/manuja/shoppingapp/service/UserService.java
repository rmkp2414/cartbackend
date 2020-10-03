package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.User;

import java.util.List;

public interface UserService {
	
    public void Save(User user);

    public void Update(User user);

    public void Delete(User user);

    public User findById(Integer id);

    public List<User> findAll();

}
