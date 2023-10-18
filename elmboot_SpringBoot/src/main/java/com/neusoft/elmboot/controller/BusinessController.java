package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.business.BusinessQueryRequest;
import com.neusoft.elmboot.model.entity.Business;
import com.neusoft.elmboot.model.vo.BusinessVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.BusinessService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {

    @Resource
    private BusinessService businessService;

    /**
     * 通过商家的类型获取商家信息列表
     *
     * @param businessQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listBusinessByOrderTypeId")
    public BaseResponse<List<BusinessVo>> listBusinessByOrderTypeId(BusinessQueryRequest businessQueryRequest) throws Exception {
        if (businessQueryRequest.getOrderTypeId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<BusinessVo> listBusinessVo = businessService.listBusinessVoByOrderTypeId(businessQueryRequest.getOrderTypeId());
        if (listBusinessVo.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(listBusinessVo);
    }

    /**
     * 通过商家Id获取商家信息
     *
     * @param businessQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getBusinessById")
    public BaseResponse<BusinessVo> getBusinessById(BusinessQueryRequest businessQueryRequest) throws Exception {
        if (businessQueryRequest.getBusinessId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        BusinessVo businessVo = businessService.getBusinessVoById(businessQueryRequest.getBusinessId());
        if (businessVo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(businessVo);
    }

    /**
     * 通过商家的名字查询商家——模糊匹配
     *
     * @param businessQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listBusinessByBusinessName")
    public BaseResponse<List<BusinessVo>> listBusinessByBusinessName(BusinessQueryRequest businessQueryRequest) throws Exception {
        List<BusinessVo> listBusinessVo = businessService.listBusinessVoByBusinessName(businessQueryRequest.getBusinessName());
        if (listBusinessVo.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(listBusinessVo);
    }
}