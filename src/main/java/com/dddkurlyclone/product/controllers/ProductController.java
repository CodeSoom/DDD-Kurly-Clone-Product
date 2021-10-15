package com.dddkurlyclone.product.controllers;

import com.dddkurlyclone.product.application.ProductService;
import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.dto.ProductData;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 저장된 상품 목록을 리턴합니다.
     *
     * @return 상품 목록
     */
    @GetMapping
    public List<Product> list() {
        return productService.getProducts();
    }

    /**
     * id가 일치하는 상품을 리턴합니다.
     *
     * @param id 찾으려는 상품의 식별자
     * @return 식별자와 일치하는 상품
     */
    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    /**
     * 새로운 상품을 생성하여 리턴합니다.
     *
     * @param productdata 생성하려는 상품의 정보
     * @return 새로운 상품
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody ProductData productdata) {
        return productService.createProducts(productdata);
    }
}
