package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.model.bo.Business;
import com.neusoft.elmboot.model.bo.VirtualWallet;
import com.neusoft.elmboot.model.vo.BusinessVo;
import com.neusoft.elmboot.model.vo.VirtualWalletVo;
import com.neusoft.elmboot.service.VirtualWalletService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {
    @Autowired
    private VirtualWalletMapper virtualWalletMapper;

    @Override
    public VirtualWalletVo getWallet(String userId) {
        try {
            VirtualWallet virtualWallet = virtualWalletMapper.getVirtualWallet(userId);
            return getVirtualWalletVo(virtualWallet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int recharge(String userId, Integer amount) {
        //先获取余额，再更新余额
        VirtualWalletVo virtualWalletVo = this.getWallet(userId);
        Integer balance = virtualWalletVo.getBalance() + amount;
        try {
            return virtualWalletMapper.updateVirtualWallet(userId, balance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int expense(String userId, Integer amount) {
        //先获取余额，再更新余额
        VirtualWalletVo virtualWalletVo = this.getWallet(userId);
        Integer balance = virtualWalletVo.getBalance() - amount;
        try {
            return virtualWalletMapper.updateVirtualWallet(userId, balance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer withdraw(String userId, Integer amount, String target) {
        switch (target) {
            case "WeChat":
                System.out.println("提现到微信账户");
                break;
            case "ALiPay":
                System.out.println("提现到支付宝账户");
                break;
            case "bankCard":
                System.out.println("提现到银行卡");
                break;
        }
        //先获取余额，再更新余额
        VirtualWalletVo virtualWalletVo = this.getWallet(userId);
        Integer balance = virtualWalletVo.getBalance() - amount;
        try {
            return virtualWalletMapper.updateVirtualWallet(userId, balance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public VirtualWalletVo getVirtualWalletVo(VirtualWallet virtualWallet) {
        if (virtualWallet == null) {
            return null;
        }
        VirtualWalletVo virtualWalletVo = new VirtualWalletVo();
        BeanUtils.copyProperties(virtualWallet, virtualWalletVo);
        return virtualWalletVo;
    }


    public List<VirtualWalletVo> getVirtualWalletVo(List<VirtualWallet> virtualWalletList) {
        if (CollectionUtils.isEmpty(virtualWalletList)) {
            return new ArrayList<>();
        }
        return virtualWalletList.stream().map(this::getVirtualWalletVo).collect(Collectors.toList());
    }
}
