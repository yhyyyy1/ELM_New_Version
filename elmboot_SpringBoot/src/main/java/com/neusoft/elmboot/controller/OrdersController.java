package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.bo.Orders;
import com.neusoft.elmboot.service.OrdersService;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/createOrders")
    public BaseResponse<Integer> createOrders(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getBusinessId() == null || orders.getDaId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = ordersService.createOrders(orders);
        return ResultUtils.success(result);
    }

    @RequestMapping("/getOrdersById")
    public BaseResponse<OrdersVo> getOrdersById(Orders orders) throws Exception {
        if (orders.getOrderId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        OrdersVo ordersVo = ordersService.getOrdersById(orders.getOrderId());
        return ResultUtils.success(ordersVo);
    }

    @RequestMapping("/listOrdersByUserId")
    public BaseResponse<List<OrdersVo>> listOrdersByUserId(Orders orders) throws Exception {
        if (orders.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<OrdersVo> ordersVoList = ordersService.listOrdersByUserId(orders.getUserId());
        return ResultUtils.success(ordersVoList);
    }

    @RequestMapping("/updateOrder")
    public BaseResponse<Integer> updateOrder(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderState() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = ordersService.updateOrder(orders.getOrderId(), orders.getOrderState());
        return ResultUtils.success(result);
    }

    @RequestMapping("/updateOrders")
    public BaseResponse<Integer> updateOrders(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = ordersService.updateOrders(orders.getOrderId(), orders.getOrderTotal());
        return ResultUtils.success(result);
    }
}