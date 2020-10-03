package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.CartItem;

import java.util.List;

public interface CartItemService {
    public void Save(CartItem cartItem);
    public void Update(CartItem cartItem);
    public void Delete(CartItem cartItem);
    public CartItem findbyID(Integer id);
    public List<CartItem> findAll();
}
