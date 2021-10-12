package com.dddkurlyclone.product.infra;

import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface JpaProductRepository extends ProductRepository, CrudRepository<Product, Long> {
  List<Product> find();

  Optional<Product> withId(Long id);
}
