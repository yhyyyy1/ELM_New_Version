package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.vo.VirtualWalletVo;
import com.neusoft.elmboot.service.VirtualWalletService;
import javafx.scene.layout.Background;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/VirtualWallet")
public class VirtualWalletController {

    @Autowired
    private VirtualWalletService virtualWalletService;

    @GetMapping
    public BaseResponse<VirtualWalletVo> getWallet(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        VirtualWalletVo virtualWalletVo = virtualWalletService.getWallet(userId);
        return ResultUtils.success(virtualWalletVo);
    }

    //充钱
    @PostMapping("/recharge")
    public BaseResponse<Integer> recharge(String userId, Integer amount) {
        if (userId == null || amount == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "充值金额应该大于0");
        }
        Integer result = virtualWalletService.recharge(userId, amount);
        return ResultUtils.success(result);
    }

    //花钱-·消费
    @PostMapping("/spend")
    public BaseResponse<Integer> expense(String userId, Integer amount) {
        if (userId == null || amount == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "消费金额应该大于0");
        }

        VirtualWalletVo virtualWalletVo = virtualWalletService.getWallet(userId);
        if (amount > virtualWalletVo.getBalance()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "您的余额不足");
        }
        Integer result = virtualWalletService.expense(userId, amount);
        return ResultUtils.success(result);
    }

    //提现withdraw
    @PostMapping("/withdraw")
    public BaseResponse<Integer> withdraw(String userId, Integer amount, String target) {
        if (userId == null || amount == null || target == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "提现金额应该大于0");
        }

        VirtualWalletVo virtualWalletVo = virtualWalletService.getWallet(userId);
        if (amount > virtualWalletVo.getBalance()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "您的余额不足");
        }
        Integer result = virtualWalletService.withdraw(userId, amount, target);
        return ResultUtils.success(result);
    }
}
