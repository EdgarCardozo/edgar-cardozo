package com.bootcamp.shopping.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;


public class Item {
    @ApiModelProperty(notes = "The price of the product")
    private Double price;
    @ApiModelProperty(notes = "The name of the product")
    private String Name;
    @ApiModelProperty(notes = "The cost of the product")
    private Double cost;
    @ApiModelProperty(notes = "The database generated Item Id")
    private int id;

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
        return id;
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
        this.id = id;
    }
}
