package com.neusoft.elmboot.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateRequest implements Serializable {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户积分
     */
    private Double point;
    private static final long serialVersionUID = 1L;
}
