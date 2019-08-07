package com.bootcamp.shopping.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartItemKey implements Serializable {
    @Column(name = "idCart")
    private int idCart;
    @Column(name = "idItem")
    private int idItem;
    public int getIdCart() {
        return idCart;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
}
