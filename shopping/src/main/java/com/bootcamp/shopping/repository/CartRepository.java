package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Cart;
import java.util.*;


public class CartRepository{
    public List<Cart> findAll(){
        return new ArrayList<Cart>();
    }
    public Cart findById(long cartId) {
        return new Cart();
    }
    public Cart save(Cart cart){
        return new Cart();
    }
    public boolean delete(Cart cart){
        return true;
    }
}
