package com.dddkurlyclone.product.application;

import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.errors.ProductNotFoundException;
import com.dddkurlyclone.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 상품의 정보를 담고 있습니다.
 */
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.find();
    }

    public Product getProduct(Long id) {
        return productRepository.withId(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
