package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Bean.CartBean;
import com.shoppingcart.Bean.UpdateCartBean;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.CartId;
import com.shoppingcart.model.User;
import com.shoppingcart.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User>getUserDetails(@PathVariable int id)
	{
		User user = userService.findUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    
	@RequestMapping(value="/cart/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartBean>getCartDetails(@PathVariable int id)
	{
		CartBean cart = userService.findCartForUser(id);
		return new ResponseEntity<CartBean>(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cart/{cartid}/add/{productid}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>addCartDetails(@PathVariable int cartid,@PathVariable int productid)
	{
		String cart = userService.addProduct(cartid,productid);
		return new ResponseEntity<String>(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cart/{cartId}/delete/{productId}",method = RequestMethod.DELETE)
	public String delete(@PathVariable int cartId,@PathVariable int productId)
	{
		int productIdValue =0;
		if(productId !=0)
			productIdValue=productId;
		String msg = userService.deleteProduct(cartId,productIdValue);
		return msg;
	}
	
	@RequestMapping(value="/cart/{cartId}/update/",method = RequestMethod.PUT)
	public String updateCart(@PathVariable int cartId, @RequestBody UpdateCartBean updatecart)
	{
		Cart cart = new Cart(); 
		
		CartId updateCartId = new CartId();
		updateCartId.setCartId(updatecart.getCartId());
		updateCartId.setProductId(updatecart.getProductId()); 
		
		cart.setCartId(updateCartId);
		cart.setQuantity(updatecart.getQuantity());
		
		return userService.updateProduct(cartId, cart);
	}
}
