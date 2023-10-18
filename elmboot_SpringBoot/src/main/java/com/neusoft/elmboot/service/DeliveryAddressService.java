package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.dto.deliveryaddress.DAAddRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAUpdateRequest;
import com.neusoft.elmboot.model.entity.DeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;

import java.util.List;

/**
 * @author 14505
 * @description 针对表【deliveryaddress】的数据库操作Service
 * @createDate 2023-10-12 13:00:52
 */
public interface DeliveryAddressService extends IService<DeliveryAddress> {

    /**
     * 列出当前用户的送餐地址
     *
     * @param userId
     * @return
     */
    List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId);


    /**
     * 通过订单地址Id获取订单地址
     *
     * @param daId
     * @return
     */
    DeliveryAddressVo getDeliveryAddressById(Integer daId);

    /**
     * 新增订单地址
     *
     * @param daAddRequest
     * @return
     */
    int saveDeliveryAddress(DAAddRequest daAddRequest);

    /**
     * 更新订单地址
     *
     * @param daUpdateRequest
     * @return
     */
    int updateDeliveryAddress(DAUpdateRequest daUpdateRequest);

    /**
     * 移除订单地址
     *
     * @param daId
     * @return
     */
    int removeDeliveryAddress(Integer daId);
}
