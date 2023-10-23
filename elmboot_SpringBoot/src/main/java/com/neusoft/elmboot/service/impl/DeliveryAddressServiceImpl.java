package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAAddRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAQueryRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAUpdateRequest;
import com.neusoft.elmboot.model.entity.Business;
import com.neusoft.elmboot.model.entity.DeliveryAddress;
import com.neusoft.elmboot.model.vo.BusinessVo;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import com.neusoft.elmboot.service.DeliveryAddressService;
import com.neusoft.elmboot.mapper.DeliveryaddressMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        QueryWrapper<DeliveryAddress> queryWrapper = new QueryWrapper<DeliveryAddress>();
        queryWrapper.eq("userId", userId);
        List<DeliveryAddress> deliveryAddressList = this.baseMapper.selectList(queryWrapper);
        return getDeliveryAddressVo(deliveryAddressList);
    }

    /**
     * 通过订单地址Id获取订单地址
     *
     * @param daId
     * @return
     */
    @Override
    public DeliveryAddressVo getDeliveryAddressById(Integer daId) {
        DeliveryAddress deliveryAddress = this.getById(daId);
        if (deliveryAddress == null) {
            return null;
        }
        return getDeliveryAddressVo(deliveryAddress);
    }

    /**
     * 新增订单地址
     *
     * @param daAddRequest
     * @return
     */
    @Override
    public int saveDeliveryAddress(DAAddRequest daAddRequest) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName(daAddRequest.getContactName());
        deliveryAddress.setContactSex(daAddRequest.getContactSex());
        deliveryAddress.setContactTel(daAddRequest.getContactTel());
        deliveryAddress.setAddress(daAddRequest.getAddress());
        deliveryAddress.setUserId(daAddRequest.getUserId());

        boolean result = this.save(deliveryAddress);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "create deliveryAddress error");
        }
        return 1;
    }

    /**
     * 更新订单地址
     *
     * @param daUpdateRequest
     * @return
     */
    @Override
    public int updateDeliveryAddress(DAUpdateRequest daUpdateRequest) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();

        deliveryAddress.setDaId(daUpdateRequest.getDaId());
        deliveryAddress.setContactName(daUpdateRequest.getContactName());
        deliveryAddress.setContactSex(daUpdateRequest.getContactSex());
        deliveryAddress.setContactTel(daUpdateRequest.getContactTel());
        deliveryAddress.setAddress(daUpdateRequest.getAddress());
        deliveryAddress.setUserId(daUpdateRequest.getUserId());

        boolean result = this.updateById(deliveryAddress);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
        }
        return 1;
    }

    /**
     * 移除订单地址
     *
     * @param daId
     * @return
     */
    @Override
    public int removeDeliveryAddress(Integer daId) {
        DeliveryAddress deliveryAddress = this.getById(daId);
        if (deliveryAddress == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "Could not find");
        }
        boolean result = this.removeById(daId);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Could not remove delivery address, database error");
        }
        return 1;
    }

    /**
     * 实体对象封装操作类
     *
     * @param daQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<DeliveryAddress> getQueryWrapper(DAQueryRequest daQueryRequest) {
        QueryWrapper<DeliveryAddress> queryWrapper = new QueryWrapper<>();
        if (daQueryRequest == null) {
            return null;
        }
        String userId = daQueryRequest.getUserId();
        Integer daId = daQueryRequest.getDaId();

        queryWrapper.eq(StringUtils.isNotBlank(userId), "userId", userId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(daId), "daId", daId);
        return queryWrapper;
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




