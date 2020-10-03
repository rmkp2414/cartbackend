package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.entity.CartItem;
import com.manuja.shoppingapp.entity.ProductItem;
import com.manuja.shoppingapp.service.CartItemService;
import com.manuja.shoppingapp.service.CartService;
import com.manuja.shoppingapp.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CartItemController {
    @Autowired
    CartItemService cartItemService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductItemService productItemService;

    @RequestMapping(value = "/cartitem",method = RequestMethod.GET)
    public String loadCartItem(ModelMap modelMap){
        CartItem cartItem = new CartItem();
        modelMap.addAttribute("cartitemObj",cartItem);

        List<CartItem>cartItemList = cartItemService.findAll();
        modelMap.addAttribute("cartItemList",cartItemList);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return  "CartItem";
    }

    @RequestMapping(value = "/cartitem",method = RequestMethod.POST)
    public String saveCartItem(CartItem cartItem,ModelMap modelMap){
        cartItemService.Save(cartItem);

        CartItem cartItem1 = new CartItem();
        modelMap.addAttribute("cartitemObj",cartItem1);

        List<CartItem>cartItemList = cartItemService.findAll();
        modelMap.addAttribute("cartItemList",cartItemList);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return  "CartItem";

    }
    @RequestMapping(value = "edit-cartitem-{id}",method = RequestMethod.GET)
    public String editCartItem(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        CartItem cartItem = cartItemService.findbyID(intId);

        modelMap.addAttribute("cartitemObj",cartItem);

        List<CartItem>cartItemList = cartItemService.findAll();
        modelMap.addAttribute("cartItemList",cartItemList);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",false);
        return  "CartItem";
    }
    @RequestMapping(value = "edit-cartitem-{id}",method = RequestMethod.POST)
    public String updateCartItem(CartItem cartItem, ModelMap modelMap){
        cartItemService.Update(cartItem);

        CartItem cartItem1 = new CartItem();
        modelMap.addAttribute("cartitemObj",cartItem1);

        List<CartItem>cartItemList = cartItemService.findAll();
        modelMap.addAttribute("cartItemList",cartItemList);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return  "CartItem";
    }
    @RequestMapping(value = "/delete-cartitem-{id}",method = RequestMethod.GET)
    public  String deleteCartItem(@PathVariable String id,ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        CartItem cartItem = cartItemService.findbyID(intId);
        cartItemService.Delete(cartItem);

        CartItem cartItem1 = new CartItem();
        modelMap.addAttribute("cartitemObj",cartItem1);

        List<CartItem>cartItemList = cartItemService.findAll();
        modelMap.addAttribute("cartItemList",cartItemList);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return  "CartItem";
    }
}
