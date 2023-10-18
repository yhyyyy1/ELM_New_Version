package com.neusoft.elmboot.controller;

import java.math.BigDecimal;
import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.orders.OrdersAddRequest;
import com.neusoft.elmboot.model.dto.orders.OrdersQueryRequest;
import com.neusoft.elmboot.model.dto.orders.OrdersUpdateRequest;
import com.neusoft.elmboot.model.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.OrdersService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    /**
     * 创建订单
     *
     * @param ordersAddRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/createOrders")
    public BaseResponse<Integer> createOrders(OrdersAddRequest ordersAddRequest) throws Exception {
        if (ordersAddRequest.getOrderId() == null || ordersAddRequest.getUserId() == null ||
                ordersAddRequest.getBusinessId() == null || ordersAddRequest.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = ordersService.createOrders(ordersAddRequest);
        return ResultUtils.success(result);
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param ordersQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getOrdersById")
    public BaseResponse<OrdersVo> getOrdersById(OrdersQueryRequest ordersQueryRequest) throws Exception {
        if (ordersQueryRequest.getOrderId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        OrdersVo ordersVo = ordersService.getOrdersById(ordersQueryRequest.getOrderId());
        if (ordersVo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(ordersVo);
    }

    /**
     * 获得某个用户的所有订单
     *
     * @param ordersQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listOrdersByUserId")
    public BaseResponse<List<OrdersVo>> listOrdersByUserId(OrdersQueryRequest ordersQueryRequest) throws Exception {
        if (ordersQueryRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<OrdersVo> ordersVoList = ordersService.listOrdersByUserId(ordersQueryRequest.getUserId());
        if (ordersVoList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(ordersVoList);
    }

    /**
     * 更新订单——更新支付状态
     *
     * @param ordersUpdateRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateOrder")
    public BaseResponse<Integer> updateOrder(OrdersUpdateRequest ordersUpdateRequest) throws Exception {
        if (ordersUpdateRequest.getOrderId() == null || ordersUpdateRequest.getOrderState() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = ordersService.updateOrder(ordersUpdateRequest.getOrderId(), ordersUpdateRequest.getOrderState());
        return ResultUtils.success(result);
    }

    /**
     * 更新订单——更新订单金额 & 订单的积分使用
     *
     * @param ordersUpdateRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateOrders")
    public BaseResponse<Integer> updateOrders(OrdersUpdateRequest ordersUpdateRequest) throws Exception {
        if (ordersUpdateRequest.getOrderId() == null || ordersUpdateRequest.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = ordersService.updateOrders(ordersUpdateRequest.getOrderId(), ordersUpdateRequest.getOrderTotal());
        return ResultUtils.success(result);
    }
}