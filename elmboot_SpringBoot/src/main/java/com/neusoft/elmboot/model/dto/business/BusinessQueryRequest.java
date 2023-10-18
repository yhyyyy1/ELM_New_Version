package com.neusoft.elmboot.model.dto.business;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessQueryRequest implements Serializable {
    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 点餐分类
     */
    private Integer orderTypeId;

    private static final long serialVersionUID = 1L;
}
