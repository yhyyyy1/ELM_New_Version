package com.neusoft.elmboot.model.dto.orders;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdersQueryRequest implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 用户编号
     */
    private String userId;
    private static final long serialVersionUID = 1L;
}
