package com.dddkurlyclone.product.errors;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Long id) {
    super("Product Not Found" + id);
  }
}
