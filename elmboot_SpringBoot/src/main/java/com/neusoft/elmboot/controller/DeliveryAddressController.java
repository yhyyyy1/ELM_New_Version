package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.bo.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import com.neusoft.elmboot.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public BaseResponse<List<DeliveryAddressVo>> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception {
        if (deliveryAddress.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<DeliveryAddressVo> deliveryAddressVoList = deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
        return ResultUtils.success(deliveryAddressVoList);
    }

    @RequestMapping("/getDeliveryAddressById")
    public BaseResponse<DeliveryAddressVo> getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        DeliveryAddressVo deliveryAddressVo = deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
        return ResultUtils.success(deliveryAddressVo);
    }

    @RequestMapping("/saveDeliveryAddress")
    public BaseResponse<Integer> saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = deliveryAddressService.saveDeliveryAddress(deliveryAddress);
        return ResultUtils.success(result);
    }

    @RequestMapping("/updateDeliveryAddress")
    public BaseResponse<Integer> updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        return ResultUtils.success(result);
    }

    @RequestMapping("/removeDeliveryAddress")
    public BaseResponse<Integer> removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
        return ResultUtils.success(result);
    }
}