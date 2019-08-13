package com.bootcamp.shopping.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserBuysItemsKey implements Serializable {
    @Column(name = "idCart")
    private int idUser;
    @Column(name = "idItem")
    private int idItem;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
}
