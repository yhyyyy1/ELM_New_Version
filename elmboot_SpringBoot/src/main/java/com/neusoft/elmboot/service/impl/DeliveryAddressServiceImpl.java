package com.neusoft.elmboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.DeliveryAddressMapper;
import com.neusoft.elmboot.model.bo.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;
import org.springframework.util.CollectionUtils;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId) {
        List<DeliveryAddress> deliveryAddressList = deliveryAddressMapper.listDeliveryAddressByUserId(userId);
        return getDeliveryAddressVo(deliveryAddressList);
    }

    @Override
    public DeliveryAddressVo getDeliveryAddressById(Integer daId) {
        DeliveryAddress deliveryAddress = deliveryAddressMapper.getDeliveryAddressById(daId);
        return getDeliveryAddressVo(deliveryAddress);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
    }


    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        return deliveryAddressMapper.removeDeliveryAddress(daId);
    }

    public DeliveryAddressVo getDeliveryAddressVo(DeliveryAddress deliveryAddress) {
        if (deliveryAddress == null) {
            return null;
        }
        DeliveryAddressVo deliveryAddressVo = new DeliveryAddressVo();
        BeanUtils.copyProperties(deliveryAddress, deliveryAddressVo);
        return deliveryAddressVo;
    }


    public List<DeliveryAddressVo> getDeliveryAddressVo(List<DeliveryAddress> deliveryAddressList) {
        if (CollectionUtils.isEmpty(deliveryAddressList)) {
            return new ArrayList<>();
        }
        return deliveryAddressList.stream().map(this::getDeliveryAddressVo).collect(Collectors.toList());
    }
}
