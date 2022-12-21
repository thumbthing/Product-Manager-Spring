package com.example.productspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.productspring.repository.ProductRepository;
import com.example.productspring.service.ProductService;

public class SpringConfig {
    private final ProductRepository productRepository;

    public SpringConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }
}
// 이거 일단 안씀