package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.repository.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private ICartRepo cartRepo;

    public List<Cart> find(){
     return cartRepo.findAll();
    }
    public Cart find(int cartId){
        Cart cart = cartRepo.findById(cartId).get();
        return cart;
    }
    public void create(Cart cart){
        cartRepo.save(cart);
    }
    public Cart update(int cartId,Cart cart){
        Cart updatedCart = cartRepo.findById(cartId).get();
        updatedCart.setPayment(cart.getPayment());
        updatedCart.setTotalPrice(cart.getTotalPrice());

        cartRepo.save(updatedCart);
        return updatedCart;
    }
    public void delete(int cartId){
        cartRepo.deleteById(cartId);
    }
}
