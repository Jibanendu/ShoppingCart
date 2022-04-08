package com.shoppingcart.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Cart {

	@EmbeddedId
	private CartId cartId;
	
	private int quantity;

	public Cart(CartId cartId,int quantity) {
		super();
		this.cartId = cartId;
		this.quantity=quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart() {
	}

	public CartId getCartId() {
		return cartId;
	}

	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}
	
	
}
