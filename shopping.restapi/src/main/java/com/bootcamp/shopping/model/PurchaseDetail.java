package com.bootcamp.shopping.model;

public class PurchaseDetail {
    private Item item;
    private int Quantity;

    public PurchaseDetail(Item item, int quantity) {
        this.item = item;
        Quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
