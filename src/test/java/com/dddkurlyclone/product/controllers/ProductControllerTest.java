package com.dddkurlyclone.product.controllers;

import com.dddkurlyclone.product.application.ProductService;
import com.dddkurlyclone.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    @DisplayName("유닛테스트 케이스를 준비합니다.")
    void setUp() {
        Product product = Product.builder()
                .id(2021L)
                .name("kurly")
                .build();

        given(productService.getProducts()).willReturn(List.of(product));
        given(productService.getProduct(2021L)).willReturn((product));
    }

    @Test
    @DisplayName("GET 메소드로 요청하면 모든 상품 목록을 리턴한다.")
    void products() throws Exception {
        mockMvc.perform(
                get("/product").accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

}