package com.neusoft.elmboot.model.dto.user;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddRequest implements Serializable {
    /**
     * 用户编号
     */
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

    private static final long serialVersionUID = 1L;
}
