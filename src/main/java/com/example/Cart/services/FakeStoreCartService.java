package com.example.Cart.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Cart.dtos.FakeStoreCartDto;
import com.example.Cart.models.Product;

import com.example.Cart.models.Cart;

@Service
public class FakeStoreCartService implements CartService{
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Cart> getAllCarts() {
        FakeStoreCartDto[] fakeStoreCartDtos =  restTemplate.getForObject("https://fakestoreapi.com/carts",FakeStoreCartDto[].class);
        List<Cart> carts = new ArrayList<>();
        for(FakeStoreCartDto ele: fakeStoreCartDtos){
            Cart cart = new Cart();
            cart.setId(ele.getId());
            cart.setUserId(ele.getUserId());
            cart.setDate(ele.getDate());
            for(int i = 0; i < ele.getProducts().size(); i++){
                cart.getProducts().get(i).setProductId(ele.getProducts().get(i).getProductId());
                cart.getProducts().get(i).setQuantity(ele.getProducts().get(i).getQuantity());
            }
            carts.add(cart);
        }
        return carts;
    }

    @Override
    public Cart getSingleCart(Long id) {
        FakeStoreCartDto fakeStoreCartDto =  restTemplate.getForObject("https://fakestoreapi.com/carts/" + id,FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < fakeStoreCartDto.getProducts().size(); i++){
            Product product = new Product();
            product.setProductId(fakeStoreCartDto.getProducts().get(i).getProductId());
            product.setQuantity(fakeStoreCartDto.getProducts().get(i).getQuantity());
            products.add(product);
        }
        cart.setProducts(products);
        return cart;
    }

    @Override
    public Cart getUserCart(Long userId) {
        FakeStoreCartDto fakeStoreCartDto =  restTemplate.getForObject("https://fakestoreapi.com/carts/user/" + userId,FakeStoreCartDto.class);
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < fakeStoreCartDto.getProducts().size(); i++){
            Product product = new Product();
            product.setProductId(fakeStoreCartDto.getProducts().get(i).getProductId());
            product.setQuantity(fakeStoreCartDto.getProducts().get(i).getQuantity());
            products.add(product);
        }
        cart.setProducts(products);
        return cart;
    }

    @Override
    public FakeStoreCartDto createCart(Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = new FakeStoreCartDto();
        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setUserId(cart.getUserId());
        fakeStoreCartDto.setDate(cart.getDate());
        fakeStoreCartDto.setProducts(cart.getProducts());
        return restTemplate.postForObject("https://fakestoreapi.com/carts", fakeStoreCartDto, FakeStoreCartDto.class);
    }

    @Override
    public void updateCart(Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = new FakeStoreCartDto();
        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setUserId(cart.getUserId());
        fakeStoreCartDto.setDate(cart.getDate());
        fakeStoreCartDto.setProducts(cart.getProducts());
        restTemplate.put("https://fakestoreapi.com/carts/" + cart.getId(), fakeStoreCartDto);
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);
    }



}
