package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.bo.DeliveryAddress;
import com.neusoft.elmboot.model.vo.DeliveryAddressVo;
import com.neusoft.elmboot.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public BaseResponse<List<DeliveryAddressVo>> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception {
        if (deliveryAddress.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<DeliveryAddressVo> deliveryAddressVoList = deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
        if (deliveryAddressVoList != null) {
            return ResultUtils.success(deliveryAddressVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前用户配送地址列表失败");
        }

    }

    @RequestMapping("/getDeliveryAddressById")
    public BaseResponse<DeliveryAddressVo> getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        DeliveryAddressVo deliveryAddressVo = deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
        if (deliveryAddressVo != null) {
            return ResultUtils.success(deliveryAddressVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前用户的某个配送地址失败");
        }
    }

    @RequestMapping("/saveDeliveryAddress")
    public BaseResponse<Integer> saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (deliveryAddress.getContactSex() != 1 && deliveryAddress.getContactSex() != 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别参数应该为1 or 0");
        }
        if (deliveryAddress.getContactTel().length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该为11位");
        }
        if (deliveryAddress.getContactTel().charAt(0) != '0' && deliveryAddress.getContactTel().charAt(0) != '1') {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该以1 或 0开头");
        }
        Integer result = deliveryAddressService.saveDeliveryAddress(deliveryAddress);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新建配送地址失败");
        }
    }

    @RequestMapping("/updateDeliveryAddress")
    public BaseResponse<Integer> updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getContactName() == null || deliveryAddress.getContactSex() == null || deliveryAddress.getContactTel() == null || deliveryAddress.getAddress() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (deliveryAddress.getContactSex() != 1 && deliveryAddress.getContactSex() != 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别参数应该为1 or 0");
        }
        if (deliveryAddress.getContactTel().length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该为11位");
        }
        if (deliveryAddress.getContactTel().charAt(0) != '0' && deliveryAddress.getContactTel().charAt(0) != '1') {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该以1 或 0开头");
        }
        Integer result = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新配送地址失败");
        }
    }

    @RequestMapping("/removeDeliveryAddress")
    public BaseResponse<Integer> removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，移除配送地址失败");
        }
    }
}