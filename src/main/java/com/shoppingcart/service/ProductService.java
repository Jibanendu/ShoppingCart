package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.shoppingcart.Bean.ProductBean;
import com.shoppingcart.model.Apparel;
import com.shoppingcart.model.Book;
import com.shoppingcart.model.Product;

import com.shoppingcart.repository.BookDAO;
import com.shoppingcart.repository.ProductDAO;

@Service
public class ProductService {    
    @Autowired
    BookDAO bookDAO;
    
    @Autowired
    ProductDAO productDAO;
	
	public List<Product> getAllProductDetails()
	{
		List<Product> liProduct = bookDAO.findAll();	
		return liProduct;
		
	}


	public ProductBean getProductByID(int id) {
		
		Optional<Product> p = bookDAO.findById(id);
		
		ProductBean pb = new ProductBean();
		if(p.isPresent())
		{
		    Product product = p.get();
			String productCategory = product.getProductCategory();
			if(productCategory.equalsIgnoreCase("Book"))
			{
			Book b = (Book) p.get();
			System.out.println(b.getAuthor()+"---"+b.getPrice());
			BeanUtils.copyProperties(b, pb);
			}
			else if(productCategory.equalsIgnoreCase("Apparel"))
			{
				Apparel a = (Apparel) p.get();
				BeanUtils.copyProperties(a, pb);
			}
		}
		
		return pb;
		
		
	}


	public List<ProductBean> getProductByName(String name) {
	
		List<Product> liProduct = productDAO.findByProductName(name);
		List<ProductBean> liPb = new ArrayList<ProductBean>();
		
		for(Product p: liProduct)
		{
			if(p.getProductCategory().equalsIgnoreCase("book"))
			{
				ProductBean pb = new ProductBean();
				System.out.println(p.toString());
				Book b = (Book) p;
				
				BeanUtils.copyProperties(p, pb);
				
				pb.setAuthor(b.getAuthor());
				pb.setGenre(b.getGenre());
				pb.setPublications(b.getPublications());
				liPb.add(pb);
			}
			
			else if(p.getProductCategory().equalsIgnoreCase("apparel"))
			{
				ProductBean pb = new ProductBean();
				System.out.println(p.toString());
				Apparel a = (Apparel) p;
				
				BeanUtils.copyProperties(p, pb);
				pb.setBrand(a.getBrand()); 
				pb.setType(a.getType());
				pb.setDesign(a.getDesign());
				liPb.add(pb);
			}
		}
		//System.out.println("Its working");
		return liPb;
	}


	public List<ProductBean> getProductByCategory(String name) {
		
		List<Product> liProduct = bookDAO.findAllByProductCategory(name.toUpperCase());
		List<ProductBean> liProductBean = new ArrayList<ProductBean>();
		for(Product p : liProduct)
		{
			if(p.getProductCategory().equalsIgnoreCase("book"))
			{
				ProductBean pb = new ProductBean();
				System.out.println(p.toString());
				Book b = (Book) p;
				
				BeanUtils.copyProperties(p, pb);
				
				pb.setAuthor(b.getAuthor());
				pb.setGenre(b.getGenre());
				pb.setPublications(b.getPublications());
				liProductBean.add(pb);
			}
			
			else if(p.getProductCategory().equalsIgnoreCase("apparel"))
			{
				ProductBean pb = new ProductBean();
				System.out.println(p.toString());
				Apparel a = (Apparel) p;
				
				BeanUtils.copyProperties(p, pb);
				pb.setBrand(a.getBrand()); 
				pb.setType(a.getType());
				pb.setDesign(a.getDesign());
				liProductBean.add(pb);
			}
		}
		
		//System.out.println("It worked!!");
		return liProductBean;
	}
	

}
