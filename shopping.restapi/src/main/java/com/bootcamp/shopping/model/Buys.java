package com.bootcamp.shopping.model;

import javax.persistence.*;

@Entity
public class Buys {
    @EmbeddedId
    UserBuysItemsKey id;
    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name="idUser")
    User user;
    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name="idItem")
    Item item;

    int quantity;

    public Buys(User user, Item item, int quantity) {
        this.setUser(user);
        this.setItem(item);
        this.setQuantity(quantity);
        UserBuysItemsKey id = new UserBuysItemsKey();
        id.setIdItem(item.getIdItem());
        id.setIdUser(user.getIdUser());
        this.setId(id);
    }

    public UserBuysItemsKey getId() {
        return id;
    }

    public void setId(UserBuysItemsKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
