package com.dddkurlyclone.product.dto;

import com.github.dozermapper.core.Mapping;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
public class ProductData {
    private Long id;

    @NotBlank
    @Mapping("name")
    private String name;

    @NotBlank
    @Mapping("price")
    private Integer price;

    public  ProductData(){}

    public ProductData(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
