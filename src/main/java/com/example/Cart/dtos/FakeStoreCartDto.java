package com.example.Cart.dtos;

import java.util.Date;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import com.example.Cart.models.Product;

@Getter
@Setter
public class FakeStoreCartDto {
    Long id;
    Long userId;
    Date date;
    List<Product> products;
}
