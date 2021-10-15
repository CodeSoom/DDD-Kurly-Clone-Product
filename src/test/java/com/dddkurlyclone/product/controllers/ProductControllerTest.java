package com.dddkurlyclone.product.controllers;

import com.dddkurlyclone.product.application.ProductService;
import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.dto.ProductData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void 상품_서비스를_호출할_테스트케이스를_준비합니다() {
        Product product = Product.builder()
                .id(1L)
                .name("샤인마토")
                .price(7000)
                .build();

        given(productService.getProducts()).willReturn(List.of(product));
        given(productService.getProduct(1L)).willReturn(product);
        given(productService.createProducts(any(ProductData.class))).willReturn(product);
    }

    @Test
    void 상품_목록_요청에_응답하는가() throws Exception {
        mvc.perform(
                get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void 상품_상세_정보_요청에_응답하는가() throws Exception {
        mvc.perform(
                get("/products/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("샤인마토")));
    }

    @Test
    void 상품_데이터_생성_요청에_응답하는가() throws Exception {
        mvc.perform(
                post("/products").accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"샤인마토\",\"price\":\"7000\"}"))
                .andExpect(status().isCreated());
    }
}
