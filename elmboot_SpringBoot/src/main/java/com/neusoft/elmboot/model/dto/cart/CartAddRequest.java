package com.neusoft.elmboot.model.dto.cart;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartAddRequest implements Serializable {
    /**
     * 食品编号
     */
    private Integer foodId;

    /**
     * 所属商家编号
     */
    private Integer businessId;

    /**
     * 所属用户编号
     */
    private String userId;

    private static final long serialVersionUID = 1L;
}
