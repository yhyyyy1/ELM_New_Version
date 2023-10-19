package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.business.BusinessQueryRequest;
import com.neusoft.elmboot.model.entity.Business;
import com.neusoft.elmboot.model.vo.BusinessVo;
import com.neusoft.elmboot.service.BusinessService;
import com.neusoft.elmboot.mapper.BusinessMapper;
import com.neusoft.elmboot.util.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 14505
 * @description 针对表【business】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:59
 */
@Service
@Slf4j
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
        implements BusinessService {

    /**
     * 通过商家的类型获取商家信息列表
     *
     * @param orderTypeId
     * @return
     */
    @Override
    public List<BusinessVo> listBusinessVoByOrderTypeId(Integer orderTypeId) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<Business>();
        queryWrapper.eq("orderTypeId", orderTypeId);
        List<Business> businessList = this.baseMapper.selectList(queryWrapper);
        return getBusinessVo(businessList);
    }

    /**
     * 通过商家Id获取商家信息
     *
     * @param businessId
     * @return
     */
    @Override
    public BusinessVo getBusinessVoById(Integer businessId) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<Business>();
        queryWrapper.eq("businessId", businessId);
        Business business = this.baseMapper.selectOne(queryWrapper);
        return getBusinessVo(business);
    }

    /**
     * 通过商家的名字查询商家——模糊匹配
     *
     * @param businessName
     * @return
     */
    @Override
    public List<BusinessVo> listBusinessVoByBusinessName(String businessName) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<Business>();
        queryWrapper.like("businessName", businessName);
        List<Business> businessList = this.baseMapper.selectList(queryWrapper);
        return getBusinessVo(businessList);
    }

    /**
     * 实体对象封装操作类
     *
     * @param businessQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<Business> getQueryWrapper(BusinessQueryRequest businessQueryRequest) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        if (businessQueryRequest == null) {
            return null;
        }
        Integer businessId = businessQueryRequest.getBusinessId();
        String businessName = businessQueryRequest.getBusinessName();
        Integer orderTypeId = businessQueryRequest.getOrderTypeId();

        // 拼接查询条件
        queryWrapper.eq(ObjectUtils.isNotEmpty(businessId), "businessId", businessId);
        queryWrapper.eq(StringUtils.isNotBlank(businessName), "businessName", businessName);
        queryWrapper.eq(ObjectUtils.isNotEmpty(orderTypeId), "orderTypeId", orderTypeId);
        return queryWrapper;
    }

    public BusinessVo getBusinessVo(Business business) {
        if (business == null) {
            return null;
        }
        BusinessVo businessVo = new BusinessVo();
        BeanUtils.copyProperties(business, businessVo);
        return businessVo;
    }

    public List<BusinessVo> getBusinessVo(List<Business> businessList) {
        if (CollectionUtils.isEmpty(businessList)) {
            return new ArrayList<>();
        }
        return businessList.stream().map(this::getBusinessVo).collect(Collectors.toList());
    }

}




