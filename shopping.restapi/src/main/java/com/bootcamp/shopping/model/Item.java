package com.bootcamp.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Item {
    @Column(name = "price")
    private Double price;
    @Column(name = "Name")
    private String Name;
    @Column(name = "cost")
    private Double cost;
    @Id
    private int idItem;
    @OneToMany(mappedBy = "item")
    private Set<CartHasItems> carts;
    public Item(){
    }
    public Item(Double cost, String name, int id) {
        this.setPrice(cost);
        this.setName(name);
        this.setId(id);
        this.setCost(cost);
    }
    public Double getPrice() {
        return price;
    }
    public String getName() {
        return Name;
    }
    public Double getCost() {
        return cost;
    }
    public int getId() {
        return idItem;
    }
    public void setPrice(Double cost) {
        this.price = cost*1.5;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public void setId(int id) {
        this.idItem = id;
    }
    public int getIdItem() {
        return idItem;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    public Set<CartHasItems> getCarts() {
        return carts;
    }
    public void setCarts(Set<CartHasItems> carts) {
        this.carts = carts;
    }
}
