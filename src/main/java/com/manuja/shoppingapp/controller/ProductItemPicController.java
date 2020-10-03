package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.ProductItem;
import com.manuja.shoppingapp.entity.ProductItemPIcture;
import com.manuja.shoppingapp.service.ProductItemPictureService;
import com.manuja.shoppingapp.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductItemPicController {
    @Autowired
    ProductItemPictureService productItemPictureService;
    @Autowired
    ProductItemService productItemService;

    @RequestMapping(value = "productitempicture",method = RequestMethod.GET)
    public String loadProductItemPicture(ModelMap modelMap){
        ProductItemPIcture productItemPIcture = new ProductItemPIcture();
        modelMap.addAttribute("ProductItemPicObj",productItemPIcture);

        List<ProductItemPIcture>productItemPIctureList = productItemPictureService.FindAll();
        modelMap.addAttribute("productItemPIctureList",productItemPIctureList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItemPictures";
    }
    @RequestMapping(value = "productitempicture",method = RequestMethod.POST)
    public  String addProductItemPicture(ProductItemPIcture productItemPIcture, ModelMap modelMap){
        productItemPictureService.Save(productItemPIcture);

        ProductItemPIcture productItemPIcture1 = new ProductItemPIcture();
        modelMap.addAttribute("ProductItemPicObj",productItemPIcture1);

        List<ProductItemPIcture>productItemPIctureList = productItemPictureService.FindAll();
        modelMap.addAttribute("productItemPIctureList",productItemPIctureList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItemPictures";
    }

    @RequestMapping(value = "edit-productitempicture-{id}",method = RequestMethod.GET)
    public String editProductItemPicture(@PathVariable String id, ModelMap modelMap){
        Integer IntId = Integer.parseInt(id);
        ProductItemPIcture productItemPIcture = productItemPictureService.FindById(IntId);

        modelMap.addAttribute("ProductItemPicObj",productItemPIcture);

        List<ProductItemPIcture>productItemPIctureList = productItemPictureService.FindAll();
        modelMap.addAttribute("productItemPIctureList",productItemPIctureList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",false);
        return "ProductItemPictures";
    }
    @RequestMapping(value = "edit-productitempicture-{id}",method = RequestMethod.POST)
    public  String UpdateProductItemPicture(ProductItemPIcture productItemPIcture, ModelMap modelMap){
        productItemPictureService.Update(productItemPIcture);

        ProductItemPIcture productItemPIcture1 = new ProductItemPIcture();
        modelMap.addAttribute("ProductItemPicObj",productItemPIcture1);

        List<ProductItemPIcture>productItemPIctureList = productItemPictureService.FindAll();
        modelMap.addAttribute("productItemPIctureList",productItemPIctureList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItemPictures";
    }
    @RequestMapping(value = "delete-productitempicture-{id}",method = RequestMethod.GET)
    public String deleteProductItemPicture(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        ProductItemPIcture productItemPIcture = productItemPictureService.FindById(intId);
        productItemPictureService.Delete(productItemPIcture);

        ProductItemPIcture productItemPIcture1 = new ProductItemPIcture();
        modelMap.addAttribute("ProductItemPicObj",productItemPIcture1);

        List<ProductItemPIcture>productItemPIctureList = productItemPictureService.FindAll();
        modelMap.addAttribute("productItemPIctureList",productItemPIctureList);

        List<ProductItem>productItemList = productItemService.FindAll();
        modelMap.addAttribute("productItemList",productItemList);

        modelMap.addAttribute("saveFlag",true);
        return "ProductItemPictures";
    }
}
