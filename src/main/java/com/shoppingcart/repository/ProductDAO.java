package com.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.shoppingcart.model.Product;

@NoRepositoryBean
public interface ProductDAO extends JpaRepository<Product,Integer> {

	List<Product> findByProductName(String name);
	
	List<Product> findAllByProductCategory(String name);
}
