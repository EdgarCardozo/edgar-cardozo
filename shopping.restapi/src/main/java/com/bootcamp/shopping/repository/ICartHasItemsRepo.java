package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.model.CartHasItems;
import com.bootcamp.shopping.model.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICartHasItemsRepo extends JpaRepository<CartHasItems, CartItemKey> {
    @Transactional
    void deleteByCart(Cart cart);
}
