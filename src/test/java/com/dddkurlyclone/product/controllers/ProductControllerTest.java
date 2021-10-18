package com.dddkurlyclone.product.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired private MockMvc mvc;

    @MockBean private ProductService productService;

    @BeforeEach
    void 상품_서비스를_호출할_테스트케이스를_준비합니다() {
        Product product = Product.builder().id(1L).name("샤인마토").price(7000).build();

        given(productService.getProducts()).willReturn(List.of(product));
        given(productService.getProduct(1L)).willReturn(product);
        given(productService.createProduct(any(ProductData.class))).willReturn(product);
        given(productService.updateProduct(eq(1L), any(ProductData.class)))
                .will(
                        invocation -> {
                            Long id = invocation.getArgument(0);
                            ProductData productData = invocation.getArgument(1);
                            return Product.builder()
                                    .id(id)
                                    .name(productData.getName())
                                    .price(productData.getPrice())
                                    .build();
                        });
    }

    @Test
    void 상품_목록_요청에_응답하는가() throws Exception {
        mvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    void 상품_상세_정보_요청에_응답하는가() throws Exception {
        mvc.perform(get("/products/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("샤인마토")));
    }

    @Test
    void 상품_데이터_생성_요청에_응답하는가() throws Exception {
        mvc.perform(
                        post("/products")
                                .accept(MediaType.APPLICATION_JSON_UTF8)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"샤인마토\",\"price\":\"7000\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void 상품_데이터_업데이트_요청에_응답하는가() throws Exception {
        mvc.perform(
                        patch("/products/1")
                                .accept(MediaType.APPLICATION_JSON_UTF8)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"샤인토마토\",\"price\":8900}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("샤인토마토")));
    }

    @Test
    void 상품_데이터_삭제_요청에_응답하는가() throws Exception {
        mvc.perform(delete("/products/1")).andExpect(status().isNoContent());
    }
}
