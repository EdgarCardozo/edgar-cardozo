package com.bootcamp.shopping.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class Cart {
    @ApiModelProperty(notes = "The database generated Cart Id")
    private int idCart;
    @ApiModelProperty(notes = "The total price of the cart")
    private Double totalPrice;
    @ApiModelProperty(notes = "Payment method of the client")
    private String payment;
    @ApiModelProperty(notes = "The possibles discounts")
    private Boolean discount;
    @ApiModelProperty(notes = "The possibles items the cart include")
    private List<Item> items;

    public Cart(){
    }
    public Cart(int idCart, Double totalPrice, String payment, Boolean discount, List<Item> items) {
        this.setIdCart(idCart);
        this.setTotalPrice(totalPrice);
        this.setPayment(payment);
        this.setDiscount(discount);
        this.setItems(items);
    }
    public int getIdCart() {
        return idCart;
    }
    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public Boolean getDiscount() {
        return discount;
    }
    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }


}
