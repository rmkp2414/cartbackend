package com.manuja.shoppingapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manuja.shoppingapp.dto.CartDto;
import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.CheckoutDto;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.service.CartService;
import com.manuja.shoppingapp.service.CategoryTypeService;
import com.manuja.shoppingapp.service.LoginService;
import com.manuja.shoppingapp.service.ProductService;

@Controller
public class CartController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    CartService cartService;
    
    @Autowired
    LoginService loginService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    //public static Integer USER_ID = 0;

    @GetMapping("/cart")
    public String cart(Model model) {
    	logger.info("Running Cart GET API Call.. User Id " + USER_ID);
    	CartDto cartDto = cartService.getUserCart(USER_ID);
    	if(cartDto != null) {
    		model.addAttribute("cart", cartDto);
    		model.addAttribute("showCheckout", cartDto.getCartItems().size() > 0 ? true : false);
    		return "Cart";
    	}else {
    		List<ProductDetailsDto> products = productService.getAllProducts();
        	model.addAttribute("products", products);
        	model.addAttribute("userId", USER_ID);
        	model.addAttribute("emptyCart", "No Items In Cart! Show More!");
    		return "Home";
    	}
    }
    
    @GetMapping("/clearCart")
    public String clearCart(Model model) {
    	logger.info("Running clearCart GET API Call.. User Id " + USER_ID);
    	ResponseDto responseDto = cartService.clearCart(USER_ID);
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
    	if(responseDto.getStatus()) {
    		model.addAttribute("emptyCart", "Cart Cleared!");
    	}else {
        	model.addAttribute("emptyCart", "No Items In Cart! Show More!");
    	}
    	model.addAttribute("userId", USER_ID);
    	model.addAttribute("categories", categories);
    	List<ProductDetailsDto> products = productService.getAllProducts();
    	model.addAttribute("products", products);
    	return "Home";
    }
    
    @PostMapping("/checkout")
    public String checkout(Model model, @ModelAttribute CheckoutDto checkoutDto) {
    	logger.info("Running checkout GET API Call.. User Id " + USER_ID);
    	CheckoutDto checkoutDtoRes = cartService.checkoutTicket(checkoutDto);
    	if(checkoutDtoRes != null) {
    		model.addAttribute("checkout", checkoutDtoRes);
//    		model.addAttribute("cartItems", cartDto.getCartItems());
//    		model.addAttribute("cartItemsLength", cartDto.getCartItems().size());
    		return "Checkout";
    	}else {
    		List<ProductDetailsDto> products = productService.getAllProducts();
        	model.addAttribute("products", products);
        	model.addAttribute("userId", USER_ID);
    		return "Home";
    	}
    }
    
    @GetMapping("/cart/{userId}/{productId}")
    public ModelAndView addItemToCArt(
    		@PathVariable Integer userId,
    		@PathVariable Integer productId,
    		Model model) {
    	logger.info("Running addItemToCArt GET API Call..");
    	ResponseDto responseDto = cartService.addProductToCart(userId,productId);
    	List<ProductDetailsDto> products = productService.getAllProducts();
    	USER_ID = userId;
    	model.addAttribute("products", products);
		model.addAttribute("userId", userId);

        return new ModelAndView("redirect:" + "/home"); 
    }

//    @RequestMapping(value = "/cart",method = RequestMethod.GET)
//    public String loadCart(ModelMap modelMap){
//        Cart cart = new Cart();
//        modelMap.addAttribute("cartObj",cart);
//
//        List<Cart>cartList = cartService.findAll();
//        modelMap.addAttribute("cartList",cartList);
//        modelMap.addAttribute("saveFlag",true);
//
//        return "Cart";
//
//    }
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    public String saveCart(Cart cart, ModelMap modelMap){
        cartService.Save(cart);

        Cart cart1 = new Cart();
        modelMap.addAttribute("cartObj",cart1);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);
        modelMap.addAttribute("saveFlag",true);

        return "Cart";
    }

    public String editCart(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        Cart cart = cartService.findbyID(intId);

        modelMap.addAttribute("cartObj",cart);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);
        modelMap.addAttribute("saveFlag",false);

        return "Cart";

    }

    public String updateCart(Cart cart, ModelMap modelMap){
        cartService.Update(cart);

        Cart cart1 = new Cart();
        modelMap.addAttribute("cartObj",cart1);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);
        modelMap.addAttribute("saveFlag",true);

        return "Cart";
    }

    public String deleteCart(@PathVariable String id, ModelMap modelMap){
        Integer intId = Integer.parseInt(id);
        Cart cart = cartService.findbyID(intId);
        cartService.Delete(cart);

        Cart cart1 = new Cart();
        modelMap.addAttribute("cartObj",cart1);

        List<Cart>cartList = cartService.findAll();
        modelMap.addAttribute("cartList",cartList);
        modelMap.addAttribute("saveFlag",true);

        return "Cart";
    }
}
