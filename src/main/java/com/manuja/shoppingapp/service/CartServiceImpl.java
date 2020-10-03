package com.manuja.shoppingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuja.shoppingapp.dto.CartDto;
import com.manuja.shoppingapp.dto.CartItemDto;
import com.manuja.shoppingapp.dto.CheckoutDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.entity.CartItem;
import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.CartItemRepository;
import com.manuja.shoppingapp.repository.CartRepository;
import com.manuja.shoppingapp.repository.ProductRepository;
import com.manuja.shoppingapp.util.RandomString;
import com.manuja.shoppingapp.util.StatusMessages;
@Service
public class CartServiceImpl implements CartService {
	
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    CartItemRepository cartItemRepository;
    
    
    @Override
    public void Save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void Update(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void Delete(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public Cart findbyID(Integer id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
    
    @Override
    @Transactional
	public CartDto getUserCart(Integer userId) {
    	User user = new User();
		user.setId(userId); 
		List<Cart> carts = cartRepository.findByUserAndStatusAndCheckout(user, true, false);
		if(carts != null && carts.size() > 0) {
			//found active cart
			List<CartItem> cartItems = cartItemRepository.findByCart(carts.get(0));
			List<CartItemDto> cartItemDtos = new ArrayList<CartItemDto>();
			Double totalAmount = 0.00;
			for (CartItem cartItem : cartItems) {
				CartItemDto cartItemDto = convertCartItemToDto(cartItem);
				totalAmount = totalAmount + cartItemDto.getSoldPrice();
				cartItemDtos.add(cartItemDto);
			}
			CartDto cartDto = new CartDto();
			cartDto.setCartId(carts.get(0).getId()); 
			cartDto.setCartItems(cartItemDtos);
			cartDto.setTotalAmount(totalAmount);
			cartDto.setUserId(userId); 
			return cartDto;
		}else {
			// no cart
			return null;
		}
	}

	private CartItemDto convertCartItemToDto(CartItem cartItem) {
		
		CartItemDto cartItemDto = new CartItemDto();
		cartItemDto.setId(cartItem.getId());
		cartItemDto.setImage("");
		cartItemDto.setProductId(cartItem.getProduct().getId());
		cartItemDto.setProductName(cartItem.getProduct().getName());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setSize(cartItem.getSize());
		cartItemDto.setSoldPrice(Double.parseDouble(cartItem.getSoldPrice()));
		cartItemDto.setTotal(Double.parseDouble(cartItem.getSoldPrice()));
		
		return cartItemDto;
	}

	@Override
	@Transactional
	public ResponseDto addProductToCart(Integer userId, Integer productId) {
		ResponseDto responseDto = new ResponseDto();
		Optional<Product> product = productRepository.findById(productId);
		if(product.isPresent()) {
			Product myProduct = product.get();
			
			//Get Existing user Active Cart
			Cart activeCart = null;
			User user = new User();
			user.setId(userId); 
			List<Cart> userCarts = cartRepository.findByUser(user);
			for (Cart cart : userCarts) {
				if(cart.isStatus()) {
					activeCart = cart;
				}
			}
			
			if(activeCart != null) {
				// Adding to Cart
				return addToCart(activeCart, myProduct);
				
			}else {
				// user has no previous active cart
				
				Cart newCart = new Cart();
				newCart.setStatus(true);
				newCart.setUser(user);
				newCart.setCheckout(false);
				newCart = cartRepository.save(newCart);
				
				// User has no previous active cart
				return addToCart(newCart, myProduct);
			}
			
			
		}else {
			// Adding to Cart Item
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
			return responseDto;
		}
		
	}
	
	private ResponseDto addToCart(Cart cart, Product myProduct) {
		ResponseDto responseDto = new ResponseDto();
		
		// Adding to Cart Item
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(myProduct);
		cartItem.setQuantity(1);
		cartItem.setSize("M");
		cartItem.setSoldPrice(myProduct.getPrice());
		
		cartItemRepository.save(cartItem);
		
		responseDto.setStatus(true);
		responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
		return responseDto;
	}

	@Override
	@Transactional
	public CheckoutDto checkoutTicket(CheckoutDto checkoutDto) {
		User user = new User();
		user.setId(checkoutDto.getUserId()); 
		List<Cart> carts = cartRepository.findByUserAndStatusAndCheckout(user, true, false);
		if(carts != null && carts.size() > 0) {
			//found active cart
			Cart activeCart = carts.get(0);
			
			//Generate Referance Number
			String easy = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";
			
			//Calculate Total Amount Safely
			List<CartItem> cartItems = cartItemRepository.findByCart(activeCart);
			List<CartItemDto> cartItemDtos = new ArrayList<CartItemDto>();
			Double totalAmount = 0.00;
			for (CartItem cartItem : cartItems) {
				CartItemDto cartItemDto = convertCartItemToDto(cartItem);
				totalAmount = totalAmount + cartItemDto.getSoldPrice();
				cartItemDtos.add(cartItemDto);
			}
			
			activeCart.setTotalAmount(totalAmount.toString()); 
			activeCart.setCheckout(true);
			activeCart.setStatus(false);
			activeCart.setReferenceNumbebr(easy);
			activeCart.setDeliveryAddress(checkoutDto.getDeliveryAddress());
			activeCart.setContactNumber(checkoutDto.getContactNumber());
			activeCart.setZipcode(checkoutDto.getZipcode()); 
			cartRepository.save(activeCart);
			
			checkoutDto.setTotalAmount(totalAmount.toString());
			checkoutDto.setReferanceNumber(activeCart.getReferenceNumbebr());
			return checkoutDto;
		}else {
			// no cart
			return null;
		}
	}

	@Override
	public ResponseDto clearCart(Integer userId) {
		User user = new User();
		user.setId(userId); 
		List<Cart> carts = cartRepository.findByUserAndStatusAndCheckout(user, true, false);
		ResponseDto responseDto = new ResponseDto();
		
		if(carts != null && carts.size() > 0) {
			//found active cart
			List<CartItem> cartItems = cartItemRepository.findByCart(carts.get(0));
			for (CartItem cartItem : cartItems) {
				//Deleting
				cartItemRepository.delete(cartItem);
			}
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
			return responseDto;
		}else {
			// no cart items available
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_NOT_EXIST.getStatusMessage());
			return responseDto;
		}
	}

}
