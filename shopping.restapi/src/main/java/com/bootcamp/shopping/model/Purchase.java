package com.bootcamp.shopping.model;

import java.util.List;

public class Purchase {
    User user;
    List<PurchaseDetail> items;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Purchase(User user, List<PurchaseDetail> items) {
        this.user = user;
        this.items = items;
    }

    public List<PurchaseDetail> getItems() {
        return items;
    }

    public void setItems(List<PurchaseDetail> items) {
        this.items = items;
    }
}
