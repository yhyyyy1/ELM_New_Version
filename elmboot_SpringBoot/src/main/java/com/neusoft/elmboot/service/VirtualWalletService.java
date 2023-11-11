package com.neusoft.elmboot.service;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.model.vo.VirtualWalletVo;

public interface VirtualWalletService {
    VirtualWalletVo getWallet(String userId);

    // 充钱
    int recharge(String userId, Integer amount);

    int expense(String userId, Integer amount);

    Integer withdraw(String userId, Integer amount, String target);
}
