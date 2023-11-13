package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.vo.TransactionFlowVo;
import com.neusoft.elmboot.model.vo.VirtualWalletVo;
import com.neusoft.elmboot.service.VirtualWalletService;
import javafx.scene.layout.Background;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/VirtualWallet")
public class VirtualWalletController {

    @Autowired
    private VirtualWalletService virtualWalletService;

    @PostMapping("/newWallet/{userId}")
    public BaseResponse<Integer> saveWallet(@PathVariable(value = "userId") String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (virtualWalletService.getWallet(userId) != null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "当前用户" + userId + " 已经存在虚拟钱包");
        }
        Integer result = virtualWalletService.saveWallet(userId);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，虚拟钱包创建失败");
        }

    }

    @GetMapping("/{userId}")
    public BaseResponse<VirtualWalletVo> getWallet(@PathVariable(value = "userId") String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        VirtualWalletVo virtualWalletVo = virtualWalletService.getWallet(userId);
        if (virtualWalletVo != null) {
            return ResultUtils.success(virtualWalletVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取虚拟钱包失败");
        }
    }

    /**
     * 充钱
     *
     * @param userId
     * @param amount
     * @return
     */
    @PostMapping("/recharge")
    public BaseResponse<Integer> recharge(@RequestParam("userId") String userId, @RequestParam("amount") Integer amount) {
        if (userId == null || amount == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "充值金额应该大于0");
        }
        Integer result = virtualWalletService.recharge(userId, amount);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，充值失败");
        }
    }

    /**
     * 花钱——消费
     *
     * @param userId
     * @param amount
     * @return
     */
    @PostMapping("/spend")
    public BaseResponse<Integer> expense(@RequestParam("userId") String userId, @RequestParam("amount") Integer amount) {
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
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，支付失败");
        }
    }

    /**
     * 提现withdraw
     *
     * @param userId
     * @param amount
     * @param target
     * @return
     */
    @PostMapping("/withdraw")
    public BaseResponse<Integer> withdraw(@RequestParam("userId") String userId, @RequestParam("amount") Integer amount, @RequestParam("amount") String target) {
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
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，提现失败");
        }
    }

    /**
     * 查看业务流水
     *
     * @param userId
     * @return
     */
    @GetMapping("/Logs/{userId}")
    public BaseResponse<List<TransactionFlowVo>> getLog(@PathVariable(value = "userId") String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<TransactionFlowVo> transactionFlowVoList = virtualWalletService.getLog(userId);
        if (transactionFlowVoList != null) {
            return ResultUtils.success(transactionFlowVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取交易流水失败");
        }

    }
}
