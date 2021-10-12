package com.dddkurlyclone.product.infra;

import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.repositories.ProductRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaProductRepository
        extends ProductRepository, CrudRepository<Product, Long> {
    List<Product> find();

    Optional<Product> withId(Long id);
}
