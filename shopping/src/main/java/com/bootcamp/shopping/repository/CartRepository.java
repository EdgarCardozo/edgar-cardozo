package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Cart;
import java.util.*;


public class CartRepository{
    public List<Cart> findAll(){
        return new ArrayList<Cart>();
    };
    public Cart findById(long cartId){
        return new Cart();
    };
    public Cart save(Cart cart){
        return new Cart();
    };
    public void delete(Cart cart){
    };
    private static CartRepository instance=null;
    private CartRepository(){
        if(instance==null){
            instance = new CartRepository();
        }
    }
    public static CartRepository getInstance(){
        return instance;
    }
}
