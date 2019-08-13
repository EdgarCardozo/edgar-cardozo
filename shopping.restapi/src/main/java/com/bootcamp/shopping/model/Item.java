package com.bootcamp.shopping.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Column(name="category")
    private String category;
    @Column(name = "price")
    private Double price;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Double cost;
    @Column(name="stock")
    private int stock;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItem;
    @OneToMany(mappedBy = "item")
    private Set<CartHasItems> carts;
    @OneToMany(mappedBy = "item")
    private Set<Buys> bougths;
    public Item(){
    }

    public Item(Double cost, String name, int id,String category, int stock) {
        this.setPrice(cost*1.5);
        this.setName(name);
        this.setId(id);
        this.setCost(cost);
        this.setCategory(category);
        this.setStock(stock);
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Double getCost() {
        return cost;
    }
    public int getId() {
        return idItem;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Set<Buys> getBougths() {
        return bougths;
    }
    public void setBougths(Set<Buys> bougths) {
        this.bougths = bougths;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setName(String name) {
        this.name = name;
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
    public Set<CartHasItems> getCarts() {
        return carts;
    }
    public void setCarts(Set<CartHasItems> carts) {
        this.carts = carts;
       }
}