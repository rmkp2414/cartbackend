package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public void Save(User user) {
        userRepository.save(user);
    }

    @Override
    public void Update(User user) {
        userRepository.save(user);
    }

    @Override
    public void Delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
