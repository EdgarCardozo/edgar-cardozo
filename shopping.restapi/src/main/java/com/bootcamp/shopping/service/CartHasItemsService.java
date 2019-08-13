package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.model.CartHasItems;
import com.bootcamp.shopping.model.PurchaseDetail;
import com.bootcamp.shopping.repository.ICartHasItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartHasItemsService {
    @Autowired
    private ICartHasItemsRepo iCartHasItemsRepo;

    public void addItemsToCart(Cart cart, List<PurchaseDetail> items) {
        for(int i=0;i<items.size();i++) {
            CartHasItems cartHasItems = new CartHasItems(cart,items.get(i).getItem(),items.get(i).getQuantity());
            iCartHasItemsRepo.save(cartHasItems);
        }
    }

    public void clearCart(Cart cart) {
        iCartHasItemsRepo.deleteByCart(cart);
    }
}
