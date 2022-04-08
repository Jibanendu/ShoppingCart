package com.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="APPAREL")
public class Apparel extends Product{
	
	String type;
	String brand;
	String design;

	public Apparel(int productId, String productName, String productCategory,float price, String type, String brand, String design) {
		super(productId, productName, price, productCategory);
		this.type = type;
		this.brand = brand;
		this.design = design;
	}

	public Apparel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	@Override
	public String toString() {
		return "Apparel [productId=" + productId + ", type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}


	
	

}
