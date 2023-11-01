package com.neusoft.elmboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.neusoft.elmboot.model.vo.BusinessVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.BusinessMapper;
import com.neusoft.elmboot.model.po.Business;
import com.neusoft.elmboot.service.BusinessService;
import org.springframework.util.CollectionUtils;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<BusinessVo> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> businessList = businessMapper.listBusinessByOrderTypeId(orderTypeId);
        return getBusinessVo(businessList);
    }

    @Override
    public BusinessVo getBusinessById(Integer businessId) {
        Business business = businessMapper.getBusinessById(businessId);
        return getBusinessVo(business);
    }

    @Override
    public List<BusinessVo> listBusinessByBusinessName(String businessName) {
        List<Business> businessList = businessMapper.listBusinessByBusinessName(businessName);
        return getBusinessVo(businessList);
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
