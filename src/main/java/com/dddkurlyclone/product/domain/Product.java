package com.dddkurlyclone.product.domain;


import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }
}
