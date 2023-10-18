package com.neusoft.elmboot.model.dto.orders;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdersUpdateRequest implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderState;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;
    private static final long serialVersionUID = 1L;
}
