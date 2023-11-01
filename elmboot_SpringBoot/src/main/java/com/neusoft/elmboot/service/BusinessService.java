package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.po.Business;
import com.neusoft.elmboot.model.vo.BusinessVo;

public interface BusinessService {
    public List<BusinessVo> listBusinessByOrderTypeId(Integer orderTypeId);

    public BusinessVo getBusinessById(Integer businessId);

    public List<BusinessVo> listBusinessByBusinessName(String businessName);
}



