package com.neusoft.elmboot.service.impl;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.DeliveryAddressMapper;
import com.neusoft.elmboot.model.po.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressMapper.getDeliveryAddressById(daId);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
    }


    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return deliveryAddressMapper.removeDeliveryAddress(daId);
    }
}
