package com.example.productspring.repository;

import com.example.productspring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataJpaProductRepository
        extends JpaRepository<Product, Long>, ProductRepository {
//    Optional<Product> findByName(String name);
//
//    Optional<Product> findByNo(Long no);
//
//    Product save(Product product);
//
//    List<Product> findAll();
//
//    void delete(Long no);
//
//    // service 에서 find save

}

/// spdjpa 는 구현체가 보이지 않는다