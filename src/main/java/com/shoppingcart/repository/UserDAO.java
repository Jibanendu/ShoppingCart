package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.model.User;

public interface UserDAO extends JpaRepository<User,Integer> {

}
