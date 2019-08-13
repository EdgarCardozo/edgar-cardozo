package com.bootcamp.shopping.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCart;
    @Column(name = "totalPrice")
    private Double totalPrice;
    @Column(name = "payment")
    private String payment;
    @Column(name = "discount")
    private Boolean discount;
    @OneToMany(mappedBy = "cart")
    private Set<CartHasItems> items;
    @OneToOne(mappedBy = "cart")
    private User user;

    public Cart(){
    }
    public Cart(int idCart, Double totalPrice, String payment, Boolean discount) {
        this.setIdCart(idCart);
        this.setTotalPrice(totalPrice);
        this.setPayment(payment);
        this.setDiscount(discount);
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
    public Set<CartHasItems> getItems() {
        return items;
    }
    public void setItems(Set<CartHasItems> items) {
        this.items = items;
    }
}
