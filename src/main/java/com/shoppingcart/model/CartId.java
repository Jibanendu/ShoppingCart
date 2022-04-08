package com.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CartId implements Serializable {
	
	int cartId; 
	int productId;
	
	public CartId() {
	}

	public CartId(int cartId, int productId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	} 
	
	
	
	

}
