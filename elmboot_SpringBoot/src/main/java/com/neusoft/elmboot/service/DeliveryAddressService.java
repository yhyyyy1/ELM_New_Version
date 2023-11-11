package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.bo.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;

public interface DeliveryAddressService {
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId);

    public DeliveryAddressVo getDeliveryAddressById(Integer daId);

    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    public int removeDeliveryAddress(Integer daId);
}