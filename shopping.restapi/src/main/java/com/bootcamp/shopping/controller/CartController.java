package com.bootcamp.shopping.controller;
import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController{
    @Autowired
    private CartService cartService;
    //Read Carts
    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.find();
    }
    //Read Cart with the id = cartId
    @GetMapping(value="/{id}")
    public Cart getCartById(@PathVariable(value = "id") int cartId){
        return cartService.find(cartId);
    }
    //Create Cart
    @PostMapping
    public void createCart(@Valid @RequestBody Cart cart){
        cartService.create(cart);
    }
    //Update Cart
    @PutMapping(value = "/{id}")
    public Cart updateCart(@PathVariable(value="id") int cartId,
                           @Valid @RequestBody Cart cartDetails){
        return cartService.update(cartId,cartDetails);
    }
    //Delete a Cart with the id given
    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable(value="id") int cartId){
        cartService.delete(cartId);
    }
}