package com.shoppingcart.Bean;

import java.util.List;

public class CartBean {
	
	String userName; 
	int userId; 
	int cartId; 
	float total;
	List<CartItems> liCartItems;
	
	public CartBean() {

	}

	public CartBean(String userName, int userId, int cartId,float total, List<CartItems> liCartItems) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.cartId = cartId;
		this.liCartItems = liCartItems;
		this.total=total;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItems> getLiCartItems() {
		return liCartItems;
	}

	public void setLiCartItems(List<CartItems> liCartItems) {
		this.liCartItems = liCartItems;
	}

	
	
	

}
