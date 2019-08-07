package com.bootcamp.shopping.service;

import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.repository.IItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private IItemRepo itemRepo;

    public List<Item> find(){
        return itemRepo.findAll();
    }

    public Item find(int itemId){
        return itemRepo.findById(itemId).get();
    }

    public Item create(Item item){
        return itemRepo.save(item);
    }
    public Item update(int itemId,Item itemDetails){
        Item updatedItem = itemRepo.findById(itemId).get();
        updatedItem.setName(itemDetails.getName());
        updatedItem.setPrice(itemDetails.getCost()*1.5);
        updatedItem.setCost(itemDetails.getCost());
        return itemRepo.save(updatedItem);
    }
    public void delete(int itemId){
        itemRepo.deleteById(itemId);
    }
}
