package com.shoppingcart.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Bean.ProductBean;
import com.shoppingcart.model.Apparel;
import com.shoppingcart.model.Book;
import com.shoppingcart.model.Product;
import com.shoppingcart.service.ProductService;


@RestController
public class ShoppingCartController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/allProducts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ProductBean>> listProducts()
	{
	   
		Collection<Product> liProduct = productService.getAllProductDetails();
		
		List<ProductBean> liPb = new ArrayList<ProductBean>();
		for(Product p: liProduct)
		{
			ProductBean pb = new ProductBean();
			
			if(p.getProductCategory().equalsIgnoreCase("book"))
			{
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
				System.out.println(p.toString());
				Apparel a = (Apparel) p;
				
				BeanUtils.copyProperties(p, pb);
				pb.setBrand(a.getBrand()); 
				pb.setType(a.getType());
				pb.setDesign(a.getDesign());
				liPb.add(pb);
			}
		}
		
		return new ResponseEntity<Collection<ProductBean>>(liPb, HttpStatus.OK);
	}
    
	@RequestMapping(value="/product/ID/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductBean>listProductsByID(@PathVariable int id)
	{
		ProductBean pb = productService.getProductByID(id);
		return new ResponseEntity<ProductBean>(pb, HttpStatus.OK);
	}
	
	@RequestMapping(value="/product/Name/{name}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ProductBean>> listProductsByName(@PathVariable String name)
	{
		List<ProductBean> pb = productService.getProductByName(name);
		return new ResponseEntity<Collection<ProductBean>>(pb, HttpStatus.OK);
	}
	
	@RequestMapping(value="/product/Category/{name}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ProductBean>> listProductsByCategory(@PathVariable String name)
	{
		List<ProductBean> pb = productService.getProductByCategory(name);
		return new ResponseEntity<Collection<ProductBean>>(pb, HttpStatus.OK);
	}
}
