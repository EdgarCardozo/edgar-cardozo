package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.repository.ItemRepository;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/item")
@Api(value="Cart Management System", description = "Operations pertaining to carts in Cart Management System")
public class ItemController {

    private ItemRepository itemRepository= ItemRepository.getInstance();

    @ApiOperation(value = "View a list of products saved on database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
    @ApiOperation(value = "View an specific product saved on database")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Successfully retrieved product"),
            @ApiResponse(code=401, message = "You are not authorized to view the resource"),
            @ApiResponse(code=403, message = "Accessing to the resource you were trying to reach is forbidden"),
            @ApiResponse(code=404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{itemId}")
    public Item getItem(@ApiParam(value = "Item id to found the item object", required = true) @PathVariable("itemId") long itemId){
        Item item = itemRepository.findById(itemId);
        return item;
    }

    @ApiOperation(value = "Save a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created product"),
            @ApiResponse(code=401, message = "You are not authorized to create the resource")
    })
    @PostMapping("/post")
    public Item addItem(@ApiParam(value = "Item object to save on database", required = true) @Valid @RequestBody Item item){
        return itemRepository.save(item);
    }

    @ApiOperation(value = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Successfully updated product"),
            @ApiResponse(code=401, message = "You are not authorized to update the resource"),
            @ApiResponse(code=403, message = "Accessing to the resource you were trying to reach is forbidden"),
            @ApiResponse(code=404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/put/{id}")
    public Item updateItem(@ApiParam(value = "Item id to update the item object",required = true) @PathVariable(value = "id") long itemId,
                                           @ApiParam(value = "Item object to save on database", required = true) @Valid @RequestBody Item itemDetails){
        Item item = itemRepository.findById(itemId);
        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getCost()*1.5);
        item.setCost(itemDetails.getCost());
        return item;
    }
    //Delete an Item with the id given
    @ApiOperation(value="Delete an existing item from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted item"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteCart(@ApiParam(value="Item id to delete from database", required = true) @PathVariable(value="id") long itemId){
        Item item = itemRepository.findById(itemId);
        itemRepository.delete(item);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return response;
    }
}

