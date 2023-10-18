package com.neusoft.elmboot.model.dto.deliveryaddress;

import lombok.Data;

import java.io.Serializable;

@Data
public class DAUpdateRequest implements Serializable {
    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人性别
     */
    private Integer contactSex;

    /**
     * 联系人电话
     */
    private String contactTel;

    /**
     * 送货地址
     */
    private String address;
    private static final long serialVersionUID = 1L;
}
