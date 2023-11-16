package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.vo.BusinessVo;
import com.neusoft.elmboot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/lists/{orderTypeId}")
    public BaseResponse<List<BusinessVo>> listBusinessByOrderTypeId(@PathVariable(value = "orderTypeId") Integer OrderTypeId) throws Exception {
        if (OrderTypeId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<BusinessVo> businessVoList = businessService.listBusinessByOrderTypeId(OrderTypeId);
        if (businessVoList != null) {
            return ResultUtils.success(businessVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取商家列表失败");
        }
    }

    @GetMapping("/businesses/{businessId}")
    public BaseResponse<BusinessVo> getBusinessById(@PathVariable(value = "businessId") Integer businessId) throws Exception {
        if (businessId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        BusinessVo businessVo = businessService.getBusinessById(businessId);
        if (businessVo != null) {
            return ResultUtils.success(businessVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取商家失败");
        }
    }

    @GetMapping("/businessNameLists/{businessName}")
    public BaseResponse<List<BusinessVo>> listBusinessByBusinessName(@PathVariable(value = "businessName", required = false) String businessName) throws Exception {
        // 此处传入的Name参数可以为空
        List<BusinessVo> businessVoList = businessService.listBusinessByBusinessName(businessName);
        if (businessVoList != null) {
            return ResultUtils.success(businessVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询商家列表失败");
        }
    }
}