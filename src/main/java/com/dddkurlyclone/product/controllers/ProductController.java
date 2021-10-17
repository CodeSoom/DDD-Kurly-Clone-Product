package com.dddkurlyclone.product.controllers;

import com.dddkurlyclone.product.application.ProductService;
import com.dddkurlyclone.product.domain.Product;
import com.dddkurlyclone.product.dto.ProductData;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * 저장된 상품 목록을 리턴합니다.
   *
   * @return 상품 목록
   */
  @GetMapping
  public List<Product> list() {
    return productService.getProducts();
  }

  /**
   * id가 일치하는 상품을 리턴합니다.
   *
   * @param id 찾으려는 상품의 식별자
   * @return 식별자와 일치하는 상품
   */
  @GetMapping("/{id}")
  public Product detail(@PathVariable Long id) {
    return productService.getProduct(id);
  }

  /**
   * 새로운 상품을 생성하여 리턴합니다.
   *
   * @param productdata 생성하려는 상품의 정보
   * @return 새로운 상품
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody ProductData productdata) {
    return productService.createProduct(productdata);
  }

  /**
   * id가 일치하는 상품을 찾아, 주어진 상품의 데이터로 수정하고 상품을 리턴합니다.
   *
   * @param id 수정하려는 상품의 식별자
   * @param productData 수정된 상품의 데이터
   * @return 수정된 상품
   */
  @PatchMapping("{id}")
  public Product patch(@PathVariable Long id, @RequestBody ProductData productData) {
    return productService.updateProduct(id, productData);
  }

  /**
   * id가 일치하는 상품을 찾아, 상품목록에서 삭제합니다.
   * @param id 삭제하려는 상품의 식별자
   */
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
