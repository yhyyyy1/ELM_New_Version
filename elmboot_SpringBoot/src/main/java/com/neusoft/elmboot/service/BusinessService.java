package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.po.Business;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);

    public List<Business> listBusinessByBusinessName(String businessName);
}



