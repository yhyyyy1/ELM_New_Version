package com.neusoft.elmboot.model.vo;

import lombok.Data;

@Data
public class UserVo {
    private String userId;
    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;
    private Integer isDelete;
}
