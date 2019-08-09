package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepo extends JpaRepository<Cart,Integer> {
}
