package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.Purchase;
import com.bootcamp.shopping.service.PurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;
    @PostMapping
    public boolean buy(@Valid @RequestBody Purchase purchase){
        return purchaseService.record(purchase);
    }
}
