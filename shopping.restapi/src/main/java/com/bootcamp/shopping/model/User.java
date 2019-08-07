package com.bootcamp.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    private int idUser;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
/*
    @OneToMany
    private  Set<Bougths> bougths;*/
}
