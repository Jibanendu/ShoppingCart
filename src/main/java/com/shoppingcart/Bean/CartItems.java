package com.shoppingcart.Bean;

public class CartItems {
	
	String productName; 
	String proudctCategory; 
	int quantity; 
	float price;
	
	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItems(String productName, String proudctCategory, int quantity, float price) {
		super();
		this.productName = productName;
		this.proudctCategory = proudctCategory;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProudctCategory() {
		return proudctCategory;
	}

	public void setProudctCategory(String proudctCategory) {
		this.proudctCategory = proudctCategory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float f) {
		this.price = f;
	}

	@Override
	public String toString() {
		return "CartItems [productName=" + productName + ", proudctCategory=" + proudctCategory + ", quantity="
				+ quantity + ", price=" + price + "]";
	} 
	
	
	

}
