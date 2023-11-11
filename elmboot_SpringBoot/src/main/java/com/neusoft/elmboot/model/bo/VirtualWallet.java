package com.neusoft.elmboot.model.bo;

import lombok.Data;

import java.util.Date;

@Data
public class VirtualWallet {
    private Long id;
    private Date createDate;
    private Integer balance;

    // 三种支付方式绑定的授权码
    private String weChat;
    private String alipay;
    private String unionPay;

    private String userId;
}
