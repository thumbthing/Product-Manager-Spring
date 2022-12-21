package com.example.productspring.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private Long no;
    private String name;
    private int price;
    private int stock;
}
