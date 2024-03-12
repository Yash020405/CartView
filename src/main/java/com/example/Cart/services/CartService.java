package com.example.Cart.services;
import com.example.Cart.dtos.FakeStoreCartDto;
import com.example.Cart.models.Cart;
import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getSingleCart(Long id);
    Cart getUserCart(Long userId);
    FakeStoreCartDto createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(Long id);
}
