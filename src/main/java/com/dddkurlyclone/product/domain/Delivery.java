package com.dddkurlyclone.product.domain;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Delivery {
    @Column
    private String earlyDelivery = "샛별배송";

    @Column
    private String howtoDelivery = "택배배송";

    @Column
    private String boxingType = "종이포장";
}
