package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import com.neusoft.elmboot.model.vo.BusinessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.po.Business;
import com.neusoft.elmboot.service.BusinessService;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<BusinessVo> listBusinessByOrderTypeId(Business business) throws Exception {
        if (business.getOrderTypeId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
    }

    @RequestMapping("/getBusinessById")
    public BusinessVo getBusinessById(Business business) throws Exception {
        if (business.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return businessService.getBusinessById(business.getBusinessId());
    }

    @RequestMapping("/listBusinessByBusinessName")
    public List<BusinessVo> listBusinessByBusinessName(Business business) throws Exception {
        if (business.getBusinessName() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return businessService.listBusinessByBusinessName(business.getBusinessName());
    }


}