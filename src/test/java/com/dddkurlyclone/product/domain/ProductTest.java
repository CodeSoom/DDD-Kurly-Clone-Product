package com.dddkurlyclone.product.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    @Test
    void 상품_auditing_테스트() {
        Product product = Product.builder()
                .id(1L)
                .name("샤인마토")
                .price(7000)
                .build();

        assertThat(product.getId()).isEqualTo(product.getId());
        assertThat(product.getName()).isEqualTo(product.getName());
        assertThat(product.getPrice()).isEqualTo(product.getPrice());
    }

    @Test
    void changeWith() {
        Product product = Product.builder()
                .id(1L)
                .name("샤인마토")
                .price(7000)
                .build();

        product.changeWith(product.builder()
                .name("샤인머스캣")
                .price(14000)
                .build());

        assertThat(product.getName()).isEqualTo("샤인머스캣");
        assertThat(product.getPrice()).isEqualTo(14000);
    }
}
