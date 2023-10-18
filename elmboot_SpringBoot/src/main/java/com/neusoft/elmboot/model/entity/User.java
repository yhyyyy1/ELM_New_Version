package com.neusoft.elmboot.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户编号
     */
    @TableId
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer userSex;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer delTag;

    /**
     * 用户积分
     */
    private Double point;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}