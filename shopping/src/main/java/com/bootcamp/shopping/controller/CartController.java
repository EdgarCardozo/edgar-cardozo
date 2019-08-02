package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.repository.CartRepository;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@Api(value="Cart Management System", description = "Operations pertaining to carts in Cart Management System")
public class CartController {

    private CartRepository cartRepository =new CartRepository();

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //Read Carts
    @ApiOperation(value="View a list of carts saved on database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }
    //Read Cart with the id = cartId
    @ApiOperation(value="Find an specific cart saved on database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved cart"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public Cart getCartById(@ApiParam(value = "Cart id from which cart object will retrieve", required = true)
                                                @PathVariable(value = "id") long cartId){
       Cart cart = cartRepository.findById(cartId);
        return cart;
    }
    //Create Cart
    @ApiOperation(value="Create a new cart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created cart"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource")
    })
    @PostMapping("/post")
    public Cart createCart(@ApiParam(value="Cart object to store in database",required = true)@Valid @RequestBody Cart cart){
        return cartRepository.save(cart);
    }
    //Update Cart
    @ApiOperation(value="Update a cart saved on repository")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update cart"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/put/{id}")
    public Cart updateCart(@ApiParam(value = "Cart id to update cart object", required = true) @PathVariable(value="id") long cartId,
                                           @ApiParam(value="Cart object to update in database",required = true)@Valid @RequestBody Cart cartDetails){
        Cart cart = cartRepository.findById(cartId);
        cart.setItems(cartDetails.getItems());
        cart.setDiscount(cartDetails.getDiscount());
        cart.setPayment(cartDetails.getPayment());
        cart.setTotalPrice(cartDetails.getTotalPrice());
        cartRepository.save(cart);
        return cart;
    }
    //Delete a Cart with the id given
    @ApiOperation(value="Delete a cart from the repository")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted cart"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteCart(@ApiParam(value="Cart id to delete from database", required = true) @PathVariable(value="id") long cartId){
        Cart cart = cartRepository.findById(cartId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",cartRepository.delete(cart));
        return response;
    }
}
