package com.neusoft.elmboot.model.dto.cart;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartUpdateRequest implements Serializable {

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

    /**
     * 同一类型食品的购买数量
     */
    private Integer quantity;

    private static final long serialVersionUID = 1L;
}
