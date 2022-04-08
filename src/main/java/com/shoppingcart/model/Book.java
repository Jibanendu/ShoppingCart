package com.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book extends Product {
	
	String genre; 
    String author; 
    String publications;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int productId, String productName, String productCategory,float price,String genre, String author, String publications) {
		super(productId, productName, price, productCategory);
		this.genre = genre;
		this.author = author;
		this.publications = publications;
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

	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publications=" + publications + "productId="+productId+ "productName="+productName+"price="+price+"]";
	}


	
    
	
	
}
