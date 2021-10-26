package com.ecommerce.shop.data.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String name;
    private Double price;
    private Currency currency;
    private String details;
    private List<String> imageUrl;
}
