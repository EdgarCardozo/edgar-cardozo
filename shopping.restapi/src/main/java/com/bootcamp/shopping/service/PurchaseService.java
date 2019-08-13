package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.*;
import com.bootcamp.shopping.repository.IBuysRepo;
import com.bootcamp.shopping.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private UserService userService;
    @Autowired
    private CartHasItemsService cartHasItemsService;
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IBuysRepo buysRepo;

    public boolean record(Purchase purchase){
        if(userService.checkLogin(purchase.getUser())){
            return false;
        }
        Cart cart;
        cart = userRepo.findByUsername(purchase.getUser().getUsername()).getCart();
        List<PurchaseDetail> items = purchase.getItems();
        for(int i=0;i<items.size();i++){
            Buys buy = new Buys(purchase.getUser(),items.get(i).getItem(),items.get(i).getQuantity());
            buysRepo.save(buy);
        }
        cartHasItemsService.clearCart(cart);
        return true;
    }

    public boolean update(Purchase purchase){
        if(userService.checkLogin(purchase.getUser())){
            return false;
        }
        Cart cart;
        cart = userRepo.findByUsername(purchase.getUser().getUsername()).getCart();
        cartHasItemsService.addItemsToCart(cart,purchase.getItems());
        return true;
    }

}
