package com.neusoft.elmboot.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryRequest implements Serializable {
    /**
     * 用户编号
     */
    private String userId;

    private static final long serialVersionUID = 1L;
}
