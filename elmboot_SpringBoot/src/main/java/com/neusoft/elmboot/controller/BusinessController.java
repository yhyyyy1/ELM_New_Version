package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.BusinessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.bo.Business;
import com.neusoft.elmboot.service.BusinessService;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/listBusinessByOrderTypeId")
    public BaseResponse<List<BusinessVo>> listBusinessByOrderTypeId(Business business) throws Exception {
        if (business.getOrderTypeId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<BusinessVo> businessVoList = businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
        return ResultUtils.success(businessVoList);
    }

    @RequestMapping("/getBusinessById")
    public BaseResponse<BusinessVo> getBusinessById(Business business) throws Exception {
        if (business.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        BusinessVo businessVo = businessService.getBusinessById(business.getBusinessId());
        return ResultUtils.success(businessVo);
    }

    @RequestMapping("/listBusinessByBusinessName")
    public BaseResponse<List<BusinessVo>> listBusinessByBusinessName(Business business) throws Exception {
        if (business.getBusinessName() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<BusinessVo> businessVoList = businessService.listBusinessByBusinessName(business.getBusinessName());
        return ResultUtils.success(businessVoList);
    }


}