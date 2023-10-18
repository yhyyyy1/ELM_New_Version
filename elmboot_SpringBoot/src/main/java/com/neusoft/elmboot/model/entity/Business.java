package com.neusoft.elmboot.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @TableName business
 */
@TableName(value = "business")
@Data
public class Business implements Serializable {
    /**
     * 商家编号
     */
    @TableId(type = IdType.AUTO)
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 商家地址
     */
    private String businessAddress;

    /**
     * 商家介绍
     */
    private String businessExplain;

    /**
     * 商家图片（base64）
     */
    private String businessImg;

    /**
     * 点餐分类
     */
    private Integer orderTypeId;

    /**
     * 起送费
     */
    private BigDecimal starPrice;

    /**
     * 配送费
     */
    private BigDecimal deliveryPrice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 浏览量
     */
    private Integer views;

    /**
     * 订单量
     */
    private Integer orderQuantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}