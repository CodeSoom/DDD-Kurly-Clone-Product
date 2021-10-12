package com.dddkurlyclone.product.controllers;

import com.dddkurlyclone.product.application.ProductService;
import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.repositories.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 상품에 대한 HTTP 요청을 서비스 객체에 전달합니다.
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> productList() {
        return productService.getProducts();
    }

    @GetMapping("{id}")
    @CrossOrigin
    public Product detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
