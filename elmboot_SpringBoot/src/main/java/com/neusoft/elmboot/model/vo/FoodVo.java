package com.neusoft.elmboot.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FoodVo implements Serializable {
    /**
     * 食品编号
     */
    private Integer foodId;

    /**
     * 食品名称
     */
    private String foodName;

    /**
     * 食品介绍
     */
    private String foodExplain;

    /**
     * 食品图片
     */
    private String foodImg;

    /**
     * 食品价格
     */
    private BigDecimal foodPrice;

    /**
     * 所属商家编号
     */
    private Integer businessId;

    /**
     * 备注
     */
    private String remarks;
}
