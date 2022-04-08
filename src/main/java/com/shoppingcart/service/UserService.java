package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.Bean.CartBean;
import com.shoppingcart.Bean.CartItems;
import com.shoppingcart.Bean.ProductBean;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.CartId;
import com.shoppingcart.model.User;
import com.shoppingcart.repository.CartDAO;
import com.shoppingcart.repository.UserDAO;

@Service
public class UserService {
	
   @Autowired
	UserDAO userDAO;
   
   @Autowired
   CartDAO cartDAO;
   
   @Autowired
   ProductService productService;
	
	public User findUser(int id) {
		
		User finalUserObj= new User();
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent())
		{
			finalUserObj= user.get();
		}
		
		return finalUserObj;
	}

	public CartBean findCartForUser(int id) {
		User user = findUser(id);
		int cartId = user.getCart();
		
		float totalAmount =0; 
		
	  List<Cart> liCart = cartDAO.findByDetailsCartId(cartId);
	  
	  List<CartItems> liCartItems = new ArrayList<CartItems>();
	  
	   for(Cart cart :liCart)
	   {
		   ProductBean pb = productService.getProductByID(cart.getCartId().getProductId());
		   
		   CartItems cartItems = new CartItems(); 
		   
		   cartItems.setProductName(pb.getProductName());
		   cartItems.setProudctCategory(pb.getProductCategory());
		   cartItems.setPrice(pb.getPrice());
		   cartItems.setQuantity(cart.getQuantity());
		   liCartItems.add(cartItems);
		   
		   totalAmount= totalAmount+pb.getPrice()*cart.getQuantity();
	   }
	   
	   CartBean cartBean = new CartBean(); 
	   
	   cartBean.setUserName(user.getUserName());
	   cartBean.setUserId(user.getUserId());
	   cartBean.setCartId(cartId);
	   cartBean.setTotal(totalAmount);
	   cartBean.setLiCartItems(liCartItems);
	  
	
		return cartBean;
	}

	public String addProduct(int cartId, int productId) {
		
		Optional<Cart> liCart = cartDAO.findByDetailsCartIdProductID(cartId,productId);
		if(liCart.isEmpty())
		{
			System.out.println("It needs to be added");
			Cart cart = new Cart(); 
			CartId cartIdObj = new CartId(cartId,productId);
			cart.setCartId(cartIdObj);
			cart.setQuantity(1);
			cartDAO.save(cart);
		}
		else
		{
			System.out.println("Need to increment the quantity to one ");
		    Optional<Cart> c = cartDAO.findByDetailsCartIdProductID(cartId,productId);
		    if(c.isPresent())
		    {
		    	Cart  cart = c.get();
		    	cart.setQuantity(cart.getQuantity()+1);
		    	cartDAO.save(cart);
		    }
		}
		
		return "Cart added";
	}

	public String updateProduct(int cartId, Cart cart) {
	 
		String result =null;
		Optional<Cart> c = cartDAO.findByDetailsCartIdProductID(cartId,cart.getCartId().getProductId());
		if(c.isPresent())
		{
		    int quantity = cart.getQuantity();
		    if(quantity ==0)
		    {
		    	deleteProduct(cartId, cart.getCartId().getProductId());
		    	result= "As quantity is 0. Item removed from the cart";
		    }
		    else if(quantity <0)
		    {
		    	result = "Invalid request.Quantity can not be negative";
		    }
		    else
		    {
		    	Cart updateCart = c.get();
		    	updateCart.setQuantity(quantity);
		    	cartDAO.saveAndFlush(updateCart);
		    	result= "Request Updated";
		    }
		}
		
		return result;
	}

	public String deleteProduct(int cartId, int productId) {
		
		String result="Nothing detected";
        if(productId ==0)
        {
        	List<Cart> liCart = cartDAO.findByDetailsCartId(cartId);
            for(Cart c: liCart)
            {
            	cartDAO.delete(c);
            	result= "Cart removed";
            }
        }
        else
        {
		    Optional<Cart> c = cartDAO.findByDetailsCartIdProductID(cartId,productId);
            if(c.isPresent())
            {
            	cartDAO.delete(c.get());
            	result= "Product ID:"+productId +" is removed from Cart";
            }
        	
        }
		return result;
	}

}
