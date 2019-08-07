package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepo extends JpaRepository<Cart,Integer> {
    //FindByCategory
    //FindByName
}
