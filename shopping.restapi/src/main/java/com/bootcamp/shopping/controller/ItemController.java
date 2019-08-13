package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.service.ItemService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private Logger logger;
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.find();
    }
    @GetMapping(value = "/name/{name}")
    public List<Item>  getByName(@PathVariable(value = "name") String itemName){
        return itemService.findByName(itemName);
    }
    @GetMapping(value = "/category/{category}")
    public List<Item> getByCategory(@PathVariable(value ="category") String itemCategory){
        return itemService.findByCategory(itemCategory);
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