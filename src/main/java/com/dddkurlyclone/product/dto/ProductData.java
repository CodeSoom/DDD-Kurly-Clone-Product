package com.dddkurlyclone.product.dto;

import com.github.dozermapper.core.Mapping;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
    private Long id;

    @NotBlank
    @Mapping("name")
    private String name;

    @NotBlank
    @Mapping("price")
    private Integer price;

}
