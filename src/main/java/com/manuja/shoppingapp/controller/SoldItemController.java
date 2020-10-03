package com.manuja.shoppingapp.controller;

import com.manuja.shoppingapp.entity.SoldItem;
import com.manuja.shoppingapp.service.SoldItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SoldItemController {
    @Autowired
    SoldItemService soldItemService;

    @RequestMapping(value = "solditem",method = RequestMethod.GET)
    public String loadSoldItems(ModelMap modelMap){
        SoldItem soldItem = new SoldItem();
        modelMap.addAttribute("soldItemObj",soldItem);

        List<SoldItem>soldItems = soldItemService.FindAll();
        modelMap.addAttribute("soldItems",soldItems);

        modelMap.addAttribute("saveFlag",true);
        return "SoldItem";
    }
    @RequestMapping(value = "solditem",method = RequestMethod.POST)
    public String saveSoldItem(SoldItem soldItem,ModelMap modelMap){
        soldItemService.Save(soldItem);

        SoldItem soldItem1 = new SoldItem();
        modelMap.addAttribute("soldItemObj",soldItem1);

        List<SoldItem>soldItems = soldItemService.FindAll();
        modelMap.addAttribute("soldItems",soldItems);

        modelMap.addAttribute("saveFlag",true);
        return "SoldItem";
    }
    @RequestMapping(value = "edit-solditem-{id}",method = RequestMethod.GET)
    public String editSoldItem(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        SoldItem soldItem = soldItemService.FindById(intId);

        modelMap.addAttribute("soldItemObj",soldItem);

        List<SoldItem>soldItems = soldItemService.FindAll();
        modelMap.addAttribute("soldItems",soldItems);

        modelMap.addAttribute("saveFlag",false);
        return "SoldItem";
    }
    @RequestMapping(value = "edit-solditem-{id}",method = RequestMethod.POST)
    public String updateSoldItem(SoldItem soldItem, ModelMap modelMap){
        soldItemService.Update(soldItem);

        SoldItem soldItem1 = new SoldItem();
        modelMap.addAttribute("soldItemObj",soldItem1);

        List<SoldItem>soldItems = soldItemService.FindAll();
        modelMap.addAttribute("soldItems",soldItems);

        modelMap.addAttribute("saveFlag",true);
        return "SoldItem";
    }
    @RequestMapping(value = "delete-solditem-{id}",method = RequestMethod.GET)
    public String deleteSoldItem(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        SoldItem soldItem = soldItemService.FindById(intId);
        soldItemService.Delete(soldItem);

        SoldItem soldItem1 = new SoldItem();
        modelMap.addAttribute("soldItemObj",soldItem1);

        List<SoldItem>soldItems = soldItemService.FindAll();
        modelMap.addAttribute("soldItems",soldItems);

        modelMap.addAttribute("saveFlag",true);
        return "SoldItem";
    }
}
