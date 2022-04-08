package com.shoppingcart.Bean;

public class UpdateCartBean {
	
	 /*"cartId":1,
     "productId":2,
     "quantity": 5*/
	
	int cartId;
	int productId;
	int quantity;
	
	public UpdateCartBean(int cartId, int productId, int quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public UpdateCartBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UpdateCartBean [cartId=" + cartId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
	
	

}
