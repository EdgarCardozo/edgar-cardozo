package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.find();
    }
    @GetMapping(value = "/{id}")
    public Item getItem(@PathVariable(value = "id") int itemId){
        return itemService.find(itemId);
    }
    @PostMapping
    public Item addItem( @Valid @RequestBody Item item){
        return itemService.create(item);
    }
    @PutMapping(value = "/{id}")
    public Item updateItem(@PathVariable(value = "id") int itemId,
                            @Valid @RequestBody Item itemDetails){
        return itemService.update(itemId,itemDetails);
    }
    //Delete an Item with the id given
    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable(value="id") int itemId){
        itemService.delete(itemId);
    }
}