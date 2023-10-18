package com.neusoft.elmboot.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 用户编号
     */
    private String userId;

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
     * 用户积分
     */
    private Double point;
}
