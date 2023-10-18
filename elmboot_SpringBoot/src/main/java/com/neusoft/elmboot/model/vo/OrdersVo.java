package com.neusoft.elmboot.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdersVo implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 订购日期
     */
    private String orderDate;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;

    /**
     * 送货地址编号
     */
    private Integer daId;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderState;
}
