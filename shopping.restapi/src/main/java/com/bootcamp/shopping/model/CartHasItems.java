package com.bootcamp.shopping.model;

import javax.persistence.*;

@Entity
public class CartHasItems {
    @EmbeddedId
    CartItemKey id;

    @ManyToOne
    @MapsId("idCart")
    @JoinColumn(name="idCart")
    Cart cart;

    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "idItem")
    Item item;

    int quantity;

    public CartHasItems(Cart cart, Item item,int quantity) {
        this.setCart(cart);
        this.setItem(item);
        this.setQuantity(quantity);
        CartItemKey cartItemKey = new CartItemKey();
        cartItemKey.setIdCart(cart.getIdCart());
        cartItemKey.setIdItem(item.getIdItem());
        this.setId(cartItemKey);
    }

    public CartHasItems() {
    }

    public CartItemKey getId() {
        return id;
    }
    public void setId(CartItemKey id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
