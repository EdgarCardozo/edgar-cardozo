package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.model.User;
import com.bootcamp.shopping.repository.ICartRepo;
import com.bootcamp.shopping.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private ICartRepo cartRepo;

    public List<User> find(){
        return userRepo.findAll();
    }
    public User register(User newUser){
        if(userRepo.findByUsername(newUser.getUsername())==null){
            Cart cart= new Cart();
            cartRepo.save(cart);
            newUser.setCart(cart);
            return userRepo.save(newUser);
        }
        //Should return errorMessage
        return null;
    }
    public boolean checkLogin(User user){
        return userRepo.findByUsername(user.getUsername()).getPassword()==user.getPassword();
    }
}
