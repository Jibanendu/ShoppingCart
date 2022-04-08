package com.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.model.Cart;

public interface CartDAO extends JpaRepository<Cart,Integer> {

	@Query(value="select PRODUCT_ID,QUANTITY,CART_ID from CART where CART_ID=?1",nativeQuery=true)
	List<Cart> findByDetailsCartId(int cartId);
	
	@Query(value="select PRODUCT_ID,QUANTITY,CART_ID from CART where CART_ID=?1 and PRODUCT_ID=?2",nativeQuery=true)
	Optional<Cart> findByDetailsCartIdProductID(int cartId, int productId);
	
	@Query(value="select PRODUCT_ID from CART where CART_ID=?1",nativeQuery=true)
	List<Integer> findAllByProductID(int cartId);

}
