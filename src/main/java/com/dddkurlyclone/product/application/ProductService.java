package com.dddkurlyclone.product.application;

import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.dto.ProductData;
import com.dddkurlyclone.product.errors.ProductNotFoundException;
import com.dddkurlyclone.product.infra.ProductRepository;
import com.github.dozermapper.core.Mapper;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
  private final Mapper mapper;
  private final ProductRepository productRepository;

  public ProductService(Mapper mapper, ProductRepository productRepository) {
    this.mapper = mapper;
    this.productRepository = productRepository;
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Product getProduct(Long id) {
    return findProduct(id);
  }

  public Product createProducts(ProductData productData) {
    Product product = mapper.map(productData, Product.class);
    return productRepository.save(product);
  }

  private Product findProduct(Long id) {
    return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
  }
}
