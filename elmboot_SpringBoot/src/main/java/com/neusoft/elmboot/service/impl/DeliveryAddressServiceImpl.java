package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAAddRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAUpdateRequest;
import com.neusoft.elmboot.model.entity.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import com.neusoft.elmboot.service.DeliveryAddressService;
import com.neusoft.elmboot.mapper.DeliveryaddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14505
 * @description 针对表【deliveryaddress】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:52
 */
@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryaddressMapper, DeliveryAddress>
        implements DeliveryAddressService {

    /**
     * 列出当前用户的送餐地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId) {
        return null;
    }

    /**
     * 通过订单地址Id获取订单地址
     *
     * @param daId
     * @return
     */
    @Override
    public DeliveryAddressVo getDeliveryAddressById(Integer daId) {
        return null;
    }

    /**
     * 新增订单地址
     *
     * @param daAddRequest
     * @return
     */
    @Override
    public int saveDeliveryAddress(DAAddRequest daAddRequest) {
        return 0;
    }

    /**
     * 更新订单地址
     *
     * @param daUpdateRequest
     * @return
     */
    @Override
    public int updateDeliveryAddress(DAUpdateRequest daUpdateRequest) {
        return 0;
    }

    /**
     * 移除订单地址
     *
     * @param daId
     * @return
     */
    @Override
    public int removeDeliveryAddress(Integer daId) {
        return 0;
    }
}




