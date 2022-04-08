package com.shoppingcart.Bean;

public class ProductBean {
	
	String genre;
	String author;
	String publications;
	int productId;
	String productName;
	float price;
	String productCategory;
	String type; 
	String brand; 
	String design;
	
	public ProductBean() {
	}

	public ProductBean(String genre, String author, String publications, int productId, String productName,
			int price,String productCategory,String type,String brand,String design) {
		super();
		this.genre = genre;
		this.author = author;
		this.publications = publications;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productCategory=productCategory;
		this.type=type; 
		this.brand=brand;
		this.design=design;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
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
		return "ProductBean [genre=" + genre + ", author=" + author + ", publications=" + publications + ", productId="
				+ productId + ", productName=" + productName + ", price=" + price + ", productCategory="
				+ productCategory + ", type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}


	
	

}
