package com.neusoft.elmboot.model.dto.cart;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartQueryRequest implements Serializable {
    /**
     * 所属用户编号
     */
    private String userId;

    /**
     * 所属商家编号
     */
    private Integer businessId;

    /**
     * 食品编号
     */
    private Integer foodId;

    private static final long serialVersionUID = 1L;
}
