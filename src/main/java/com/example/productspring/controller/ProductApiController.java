package com.example.productspring.controller;

import com.example.productspring.domain.Product;
import com.example.productspring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
// 컨트롤러를 일단 해줘야 작동함
public class ProductApiController {

    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    //read
    @GetMapping("/api")
    public String getProduct() {

        return "product/api/apiPage";
    }
    //create

//    @GetMapping("/products")
//    @PostMapping
//    public List<Product> listProduct(@RequestBody Product product) {
//        Long no = productService.join(product);
//        return productService.findOne(no);
//        // 등록하고
//        // 등록한 객체를 리턴
////       json을 받아서
////     그걸 파싱하고 서버로 보내준다
//
//    }

    //read
    @GetMapping("/api/products")
    // responsebody 하면 json객체로 바뀜
    @ResponseBody
    public List<Product> list() {
        System.out.println("list start");
        List<Product> products = productService.findProduct();

        System.out.println(products.toString());
        return products;
//        return "product/api/products";
    }

//    update
    @PutMapping("/products/{no}")
    public Product updateProduct(@PathVariable Long no, @RequestBody ProductForm form) {
        Product product = productService.findOne(no).get();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStock(form.getStock());

        productService.update(product);

        return productService.findOne(no).get();
    }
//  json을 받아서
/// 파싱하고 그걸 서버로 보내준다

// 스테이터스 보내줘야한다


    // delete
    @DeleteMapping("/products/{no}")
    void deleteProduct(@PathVariable Long no) {
        productService.delete(no);
    }
}


// html은 get과 post밖에 못써서