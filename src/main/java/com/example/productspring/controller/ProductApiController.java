package com.example.productspring.controller;

import com.example.productspring.domain.Product;
import com.example.productspring.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class ProductApiController {

    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    //read
    @GetMapping("/products")
    public List<Product> getProduct() {
        List<Product> products = productService.findProduct();
        return products;
    }
    //create
//    @PostMapping
//    public Product postProduct() {
//       json을 받아서
    // 그걸 파싱하고 서버로 보내준다
//    }
//
    //update
//    @PutMapping
//  json을 받아서
/// 파싱하고 그걸 서버로 보내준다



    // delete
//    @DeleteMapping
//    // json을 받아서 그걸 서버로 보내준다
//
//
}
