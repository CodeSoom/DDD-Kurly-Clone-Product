package com.dddkurlyclone.product.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class Quantity {
    @Column
    private Integer quantity;
}
