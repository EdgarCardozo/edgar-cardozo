package com.bootcamp.shopping.ServiceTest;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.model.CartHasItems;
import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.model.PurchaseDetail;
import com.bootcamp.shopping.repository.ICartHasItemsRepo;
import com.bootcamp.shopping.service.CartHasItemsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartHasItemsServiceTest {
    @Mock
    private ICartHasItemsRepo cartHasItemsRepo;
    @Autowired
    private CartHasItemsService cartHasItemsService;
    private Cart cart;
    private Item item;
    private CartHasItems cartHasItems;
    private List<PurchaseDetail> items = new ArrayList<>();
    @Before
    public void set(){
        cart = new Cart();
        cart.setIdCart(14);
        item = new Item();
        item.setId(15);
        PurchaseDetail purchaseDetail = new PurchaseDetail(item,4);
        items.add(purchaseDetail);
    }

    @After
    public void clear(){
        cart = null;
        item = null;
        items= null;
    }

    @Test
    public void whenAnItemIsAddedToACartThenItIsSavedOnRepo(){
        when(cartHasItemsRepo.save(cartHasItems)).thenReturn(null);
        cartHasItemsService.addItemsToCart(cart,items);
        Mockito.verify(cartHasItemsRepo).save(cartHasItems);
    }

    /*@Test
    public void whenTheCartIsClearedThenTheRepoDeleteTheCart(){
        when(cartHasItemsRepo.deleteByCart(cart)).thenReturn(null);
    }*/


}
