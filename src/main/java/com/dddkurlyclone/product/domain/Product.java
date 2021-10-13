package com.dddkurlyclone.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
  @Id @GeneratedValue
  private Long id;

  private String name;

  private Integer price;

  @Builder
  public Product(Long id, String name, Integer price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}
