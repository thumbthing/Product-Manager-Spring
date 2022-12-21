package com.example.productspring.repository;

import com.example.productspring.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findByNo(Long no);

    Optional<Product> findByName(String name);

    List<Product> findAll();

    void delete(Product product);
}
// sdjpa 에서 매개변수만 보고 알아서 처리해줌
//
