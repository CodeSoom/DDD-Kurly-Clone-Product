package com.dddkurlyclone.product.repositories;

import com.dddkurlyclone.product.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * 상품을 찾고, 저장하고, 삭제하는 메소드 입니다.
 */
public interface ProductRepository {
    List<Product> find();

    Optional<Product> withId(Long id);
}
