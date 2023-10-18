package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAAddRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAEditRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAQueryRequest;
import com.neusoft.elmboot.model.dto.deliveryaddress.DAUpdateRequest;
import com.neusoft.elmboot.model.entity.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.DeliveryAddressService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Resource
    private DeliveryAddressService deliveryAddressService;
    // todo 权限校验——一定是本登录用户的！！

    /**
     * 列出当前用户的送餐地址
     *
     * @param daQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listDeliveryAddressByUserId")
    public BaseResponse<List<DeliveryAddressVo>> listDeliveryAddressByUserId(DAQueryRequest daQueryRequest)
            throws Exception {
        if (daQueryRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<DeliveryAddressVo> deliveryAddressVoList = deliveryAddressService.listDeliveryAddressByUserId(daQueryRequest.getUserId());
        if (deliveryAddressVoList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(deliveryAddressVoList);
    }

    /**
     * 通过订单地址Id获取订单地址
     *
     * @param daQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getDeliveryAddressById")
    public BaseResponse<DeliveryAddressVo> getDeliveryAddressById(DAQueryRequest daQueryRequest) throws
            Exception {
        if (daQueryRequest.getDaId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        DeliveryAddressVo deliveryAddress = deliveryAddressService.getDeliveryAddressById(daQueryRequest.getDaId());
        if (deliveryAddress == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(deliveryAddress);
    }

    /**
     * 新增订单地址
     *
     * @param daAddRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveDeliveryAddress")
    public BaseResponse<Integer> saveDeliveryAddress(DAAddRequest daAddRequest) throws Exception {
        if (daAddRequest.getContactName() == null || daAddRequest.getContactSex() == null ||
                daAddRequest.getAddress() == null || daAddRequest.getContactTel() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = deliveryAddressService.saveDeliveryAddress(daAddRequest);
        return ResultUtils.success(result);
    }

    /**
     * 更新订单地址
     *
     * @param daUpdateRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateDeliveryAddress")
    public BaseResponse<Integer> updateDeliveryAddress(DAUpdateRequest daUpdateRequest) throws Exception {
        if (daUpdateRequest.getContactName() == null || daUpdateRequest.getContactSex() == null ||
                daUpdateRequest.getContactTel() == null || daUpdateRequest.getAddress() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = deliveryAddressService.updateDeliveryAddress(daUpdateRequest);
        return ResultUtils.success(result);
    }

    /**
     * 移除订单地址
     *
     * @param daEditRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/removeDeliveryAddress")
    public BaseResponse<Integer> removeDeliveryAddress(DAEditRequest daEditRequest) throws Exception {
        if (daEditRequest.getDaId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = deliveryAddressService.removeDeliveryAddress(daEditRequest.getDaId());
        return ResultUtils.success(result);

    }
}