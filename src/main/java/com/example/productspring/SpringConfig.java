package com.example.productspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.productspring.repository.ProductRepository;
import com.example.productspring.service.ProductService;

//@Configuration
public class SpringConfig {
    private final ProductRepository productRepository;

    public SpringConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }
    // spring 에서 사용하는 인스턴스
    // spring 객체를 생성해 주기 위해서 bean을 사용한다
    // spring에서 사용할 객체를 만들어주기 위해서

    // 싱글톤으로 생성해준다
    // bean 컨테이너에 기능들이 들아가고
    // 이제 그것들을 사용하면 됨

    // product service를 만들려면
    // repositry를 만들어야하므로 (의존성)
    // repository를 만들은 후에
    // bean에 있는 걸 만든다  (순서)
}
// 이거 일단 안씀