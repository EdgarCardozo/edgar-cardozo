package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Purchase;
import com.bootcamp.shopping.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @PostMapping("/buy")
    public boolean buy(@Valid @RequestBody Purchase purchase){
        return purchaseService.record(purchase);
    }

    @PutMapping("/build")
    public boolean buildCart(@Valid @RequestBody Purchase purchase){
        return purchaseService.update(purchase);
    }
}
