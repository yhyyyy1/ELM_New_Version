package com.neusoft.elmboot.model.dto.deliveryaddress;

import lombok.Data;

import java.io.Serializable;

@Data
public class DAEditRequest implements Serializable {
    /**
     * 送货地址编号
     */
    private Integer daId;
    private static final long serialVersionUID = 1L;
}
