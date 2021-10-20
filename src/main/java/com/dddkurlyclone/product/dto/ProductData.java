package com.dddkurlyclone.product.dto;

import com.github.dozermapper.core.Mapping;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductData {
    private Long id;

    @NotBlank
    @Mapping("name")
    private String name;

    @NotBlank
    @Mapping("price")
    private Integer price;

    @Builder
    public ProductData(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
