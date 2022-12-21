package com.example.productspring.service;

import com.example.productspring.domain.Product;
import com.example.productspring.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// bean 등록 말고 이렇게 따로따로 어노테이션 달아주는게 편하다
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 중복 검사
    public Long join(Product product) {
        validateDuplicateProduct(product);
        productRepository.save(product);
        return product.getNo();
    }

    private void validateDuplicateProduct(Product product) {
        productRepository.findByName(product.getName())
            .ifPresent(p -> {
                throw new IllegalStateException("product already exist");
            });
    }


    // 지금 이거 조금만 더 작성하며 될듯
    // delete from db
//    public void delete(Product product) {
//        // 가져온 상품을 지워주기
//        productRepository.delete(product);
//    }

    public void delete(Long no) {
        productRepository.delete(productRepository.findByNo(no).get());
    }



    // update from db
    @Transactional
    public void update(Product product) {

        Product productForUpdate = productRepository.findByNo(product.getNo()).get();
        productForUpdate.setName(product.getName());
        productForUpdate.setPrice(product.getPrice());
        productForUpdate.setStock(product.getStock());

    }

    public List<Product> findProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findOne(Long productNo) {
        return productRepository.findByNo(productNo);
    }



}
