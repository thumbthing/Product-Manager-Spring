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
    // client로 부터 url에 있는것을 식별해서 저게 있으면 Get으로 가져온다
    public String createForm() {
        System.out.println("createForm 진입");
        return "product/createProductForm";
        //컨트롤러에서 view를 검색해서 client에게 서버사이드 렌더링을 해서 보내준다
    }
    @PostMapping("/product/create")
    // client 로부터 받는 url을 검색하고 식별해서 post를 실행
    public String create(ProductForm form) {
        // client로부터 받은 데이터를 form 형식으로 받아와서
        // 그걸 이제 가공해서 Service에게 보내줄꺼다
        Product product = new Product();
        product.setName((form.getName()));
        product.setPrice((form.getPrice()));
        product.setStock((form.getPrice()));

        productService.join(product);
        // join은 service 영역에 있는 함수

        return "redirect:/";
        //모든 작업이 끝난 이후엔 다시 전 경로를 리턴해주는 것임
    };

    // read
    @GetMapping("/productList")
    public String list(Model model) {
        List<Product> products = productService.findProduct();
        // 서비스 영역에 있는 findproduct 함수를 이용해서 List 에 넣어준다
        model.addAttribute("productList", products);
        // view 영역에 List를 넣어서 이제 view에게 보내줄꺼임
//        System.out.println(productService.findOne(products.no));
        return "product/readProductList";
    }
    // list(Model model)
    // List<Product> 컬렉션을 이용해서 서버로부터 데이터를 받아서 넣어준다
    // model 객체를 이용해서 view로 보내줄 데이터를 넣어서(위에서 받은 list 컬렉션


    // update
    @GetMapping("/product/update/{no}")
    public String updateForm(@PathVariable("no") Long no, Model model) {
        // List에서 동기적으로 생성한 HTML에 생성된 링크된 URL에 있는 값에서
        // no 값을 일단은 넣어줄꺼다 왜냐하면 client 측에서는 PK(no)를 따로 입력 안해주고 URL에 있는 값을 이욯할 것이기 때문

        model.addAttribute("no", no);
        return "product/updateProductForm";
    }

    @PostMapping("/product/update/{no}")
    public String update(ProductForm form, @PathVariable("no") Long no) {
    // client가 보내온 URL 과 HTML에 작성된 것들을 form으로 받아올 꺼다
        // NO : 직접 입력 안했지만 URL 값에서 가져올 것이기 때문에
        // @PathVariable("no") URL 에서 저 기준으로 검색하는 어노테이션을 한다
        // client로 부터 받은 form에 있는 양식을 이용해서 이제 ENTITY 양식에 맞춰서 작성한다

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


//    @GetMapping("/api")
//    public String apiPage() {
//        System.out.println("start");
//        return "product/api/apiPage";
//    }
}
