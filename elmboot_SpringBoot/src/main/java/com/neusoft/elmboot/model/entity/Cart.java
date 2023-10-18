package com.neusoft.elmboot.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cart
 */
@TableName(value ="cart")
@Data
public class Cart implements Serializable {
    /**
     * 无意义编号
     */
    @TableId(type = IdType.AUTO)
    private Integer cartId;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}