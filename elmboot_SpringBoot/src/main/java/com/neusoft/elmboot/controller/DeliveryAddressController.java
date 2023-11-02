package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.po.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception {
        if (deliveryAddress.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
    }

    @RequestMapping("/getDeliveryAddressById")
    public DeliveryAddressVo getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
    }

    @RequestMapping("/saveDeliveryAddress")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
    }
}