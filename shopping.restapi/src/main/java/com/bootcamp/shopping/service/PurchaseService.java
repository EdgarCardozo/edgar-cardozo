package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    public boolean record(Purchase purchase){
        if(userService.checkLogin(purchase.getUser())){
            return false;
        }
        cartService.delete(purchase.getCart().getIdCart());
        return true;
    }
}
