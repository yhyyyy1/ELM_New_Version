package com.neusoft.elmboot.model.dto.food;

import lombok.Data;

import java.io.Serializable;

@Data
public class FoodQueryRequest implements Serializable {
    /**
     * 所属商家编号
     */
    private Integer businessId;
    private static final long serialVersionUID = 1L;
}
