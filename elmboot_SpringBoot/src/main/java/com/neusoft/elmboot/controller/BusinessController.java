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
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<BusinessVo> businessVoList = businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
        if (businessVoList != null) {
            return ResultUtils.success(businessVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取商家列表失败");
        }

    }

    @RequestMapping("/getBusinessById")
    public BaseResponse<BusinessVo> getBusinessById(Business business) throws Exception {
        if (business.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        BusinessVo businessVo = businessService.getBusinessById(business.getBusinessId());
        if (businessVo != null) {
            return ResultUtils.success(businessVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取商家失败");
        }
    }

    @RequestMapping("/listBusinessByBusinessName")
    public BaseResponse<List<BusinessVo>> listBusinessByBusinessName(Business business) throws Exception {
        if (business.getBusinessName() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<BusinessVo> businessVoList = businessService.listBusinessByBusinessName(business.getBusinessName());
        if (businessVoList != null) {
            return ResultUtils.success(businessVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询商家列表失败");
        }
    }


}