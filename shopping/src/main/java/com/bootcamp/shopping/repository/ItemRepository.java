package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private static ItemRepository instance=null;
    public static List<Item> findAll(){
        return new ArrayList<Item>();
    }
    public static Item findById(long itemId){
        return new Item();
    }
    public static Item save(Item item){
        return new Item();
    }
    public static void delete(Item item){

    }
    private ItemRepository(){

    }
    public static ItemRepository getInstance(){
        if(instance==null){
            instance= new ItemRepository();
        }
        return instance;
    }
}
