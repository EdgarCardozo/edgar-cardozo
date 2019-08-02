package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    public List<Item> findAll(){
        return new ArrayList<Item>();
    }
    public Item findById(long itemId){
        return new Item();
    }
    public Item save(Item item){
        return new Item();
    }
    public boolean delete(Item item){
        return true;
    }
    public ItemRepository(){

    }
}
