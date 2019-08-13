package com.bootcamp.shopping.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToOne
    @JoinColumn(name = "cart",referencedColumnName = "idCart")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Buys> buys;

    public User(String username, String password, Cart cart) {
        this.username = username;
        this.password = password;
        this.cart = cart;
    }
    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
