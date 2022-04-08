package com.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userId; 
	String userName; 
	int cartId;
	
	public User() {
	}

	public User(int userId, String userName, int cartId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCart() {
		return cartId;
	}

	public void setCart(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", cart=" + cartId + "]";
	}
	

}
