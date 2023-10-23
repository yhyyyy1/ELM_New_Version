package com.neusoft.elmboot.model.dto.orders;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdersAddRequest implements Serializable {
    /**
     * 送货地址编号
     */
    private Integer daId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;
    private static final long serialVersionUID = 1L;
}
