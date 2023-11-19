package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.bo.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;

public interface DeliveryAddressService {
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId);

    public DeliveryAddressVo getDeliveryAddressById(Integer daId);

    public int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address);

    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address);

    public int removeDeliveryAddress(Integer daId);
}