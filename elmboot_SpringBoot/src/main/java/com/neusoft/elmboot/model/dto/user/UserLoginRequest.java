package com.neusoft.elmboot.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 3191241716373120793L;
}
