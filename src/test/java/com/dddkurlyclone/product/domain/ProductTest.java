package com.dddkurlyclone.product.domain;

import com.dddkurlyclone.product.infra.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품_auditing_테스트() {
        Product product = Product.builder()
                .id(1L)
                .name("샤인마토")
                .price(7000)
                .build();

        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct.getId()).isEqualTo(1L);
        assertThat(savedProduct.getName()).isEqualTo("샤인마토");
        assertThat(savedProduct.getPrice()).isEqualTo(7000);
        assertThat(savedProduct.getCreatedAt()).isNotNull();
        assertThat(savedProduct.getUpdatedAt()).isNotNull();
    }

    @Test
    void changeWith() {
        Product product = Product.builder()
                .id(1L)
                .name("샤인마토")
                .price(7000)
                .build();

        product.changeWith(Product.builder()
                .name("샤인머스캣")
                .price(14000)
                .build());

        assertThat(product.getName()).isEqualTo("샤인머스캣");
        assertThat(product.getPrice()).isEqualTo(14000);
    }
}
