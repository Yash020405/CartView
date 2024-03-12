package com.example.Cart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.Cart.models.Cart;
import com.example.Cart.services.FakeStoreCartService;

@RestController
public class CartController {
    FakeStoreCartService cs;

    CartController(FakeStoreCartService cs) {
        this.cs = cs;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts(){
        return cs.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable Long id){
        return cs.getSingleCart(id);
    }

    @GetMapping("/carts/user/{userId}")
    public Cart getUserCart(@PathVariable Long userId){
        return cs.getUserCart(userId);
    }

    @PostMapping("/carts")
    public void createCart(@RequestBody Cart cart){
        cs.createCart(cart);
    }

    @PutMapping("/carts")
    public void updateCart(@RequestBody Cart cart){
        cs.updateCart(cart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable Long id){
        cs.deleteCart(id);
    }




}
