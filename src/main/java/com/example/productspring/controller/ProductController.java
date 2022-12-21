package com.example.productspring.controller;

import com.example.productspring.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.productspring.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    // create
    @GetMapping(value = "/product/create")
    public String createForm() {
        System.out.println("createForm 진입");
        return "product/createProductForm";
    }
    @PostMapping("/product/create")
    public String create(ProductForm form) {
        Product product = new Product();
        product.setName((form.getName()));
        product.setPrice((form.getPrice()));
        product.setStock((form.getPrice()));

        productService.join(product);
        return "redirect:/";
    };

    // read
    @GetMapping("/productList")
    public String list(Model model) {
        List<Product> products = productService.findProduct();
        model.addAttribute("productList", products);
//        System.out.println(productService.findOne(products.no));
        return "product/readProductList";
    }

    // update
    @GetMapping("/product/update/{no}")
    public String updateForm(@PathVariable("no") Long no, Model model) {
        model.addAttribute("no", no);
        return "product/updateProductForm";
    }

    @PostMapping("/product/update/{no}")
    public String update(ProductForm form, @PathVariable("no") Long no) {

        System.out.println("PostUpdate 진입!!!");

        System.out.println(form.getName());
        System.out.println(form.getPrice());
        System.out.println(form.getStock());
        System.out.println(no);

        Product product = new Product();
        product.setNo(no);
        product.setName((form.getName()));
        product.setPrice((form.getPrice()));
        product.setStock((form.getStock()));

        productService.update(product);
        return "redirect:/productList";
    };

    // delete
    @GetMapping("/product/delete/{no}")
    public String deleteForm(@PathVariable("no") Long no) {
//        Product product = productService.findOne(no).get();
//        productService.delete(product);
        // 위에 작성한 것은 서버로부터 삭제할 데이터를 product에 넣고 그걸 그대로 사용하는 방식
        // 서비스 호출
        productService.delete(no);

        return "redirect:/productList";
    }

}
