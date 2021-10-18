package com.dddkurlyclone.product.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class EachProduct {
    @Column
    private String each;

    @Column
    private Long weight;
}
