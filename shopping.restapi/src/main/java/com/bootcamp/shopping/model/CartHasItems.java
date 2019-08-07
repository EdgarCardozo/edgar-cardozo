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

    public CartHasItems(CartItemKey id, int quantity) {
        this.id = id;
        this.quantity = quantity;
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
}
