package com.neusoft.elmboot.model.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderdetailetVo implements Serializable {
    /**
     * 订单明细编号
     */
    private Integer odId;

    /**
     * 所属订单编号
     */
    private Integer orderId;

    /**
     * 食品编号
     */
    private Integer foodId;

    /**
     * 数量
     */
    private Integer quantity;
}
