package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.entity.ProductItem;
import com.manuja.shoppingapp.service.ProductItemService;
import com.manuja.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductItemController {
    @Autowired
    ProductItemService productItemService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "productitem",method = RequestMethod.GET)
    public String loadProductItem(ModelMap modelMap){
        ProductItem productItem = new ProductItem();
        modelMap.addAttribute("productItemObj",productItem);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        List<Product>productList = productService.findAll();
        modelMap.addAttribute("productList",productList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItem";
    }
    @RequestMapping(value = "productitem",method = RequestMethod.POST)
    public String addProductItem(ProductItem productItem, ModelMap modelMap){
        productItemService.Save(productItem);

        ProductItem productItem1 = new ProductItem();
        modelMap.addAttribute("productItemObj",productItem1);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        List<Product>productList = productService.findAll();
        modelMap.addAttribute("productList",productList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItem";
    }
    @RequestMapping(value = "edit-productitem-{id}",method = RequestMethod.GET)
    public String editProductItem(@PathVariable String id, ModelMap modelMap){
        Integer Id = Integer.parseInt(id);
        ProductItem productItem = productItemService.FindById(Id);
        modelMap.addAttribute("productItemObj",productItem);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        List<Product>productList = productService.findAll();
        modelMap.addAttribute("productList",productList);

        modelMap.addAttribute("saveFlag",false);
        return "ProductItem";
    }
    @RequestMapping(value = "edit-productitem-{id}",method = RequestMethod.POST)
    public  String updateProductItem(ProductItem productItem, ModelMap modelMap){
        productItemService.Update(productItem);

        ProductItem productItem1 = new ProductItem();
        modelMap.addAttribute("productItemObj",productItem1);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        List<Product>productList = productService.findAll();
        modelMap.addAttribute("productList",productList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItem";
    }
    @RequestMapping(value = "delete-productitem-{id}",method = RequestMethod.GET)
    public String deleteProductItem(@PathVariable String id, ModelMap modelMap){
        Integer Id = Integer.parseInt(id);
        ProductItem productItem = productItemService.FindById(Id);
        productItemService.Delete(productItem);

        ProductItem productItem1 = new ProductItem();
        modelMap.addAttribute("productItemObj",productItem1);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        List<Product>productList = productService.findAll();
        modelMap.addAttribute("productList",productList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItem";
    }

}
