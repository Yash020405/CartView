package com.example.Cart.models;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Cart {
    Long id;
    Long userId;
    Date date;
    List<Product> products;
    Long __v = 0L;
}
