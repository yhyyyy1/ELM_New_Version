package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neusoft.elmboot.model.bo.Orders;
import com.neusoft.elmboot.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{orderId}")
    public BaseResponse<OrdersVo> getOrdersById(@PathVariable(value = "orderId") Integer orderId) throws Exception {
        if (orderId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        OrdersVo ordersVo = ordersService.getOrdersById(orderId);
        if (ordersVo != null) {
            return ResultUtils.success(ordersVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取订单失败");
        }
    }

    @GetMapping("/lists/{userId}")
    public BaseResponse<List<OrdersVo>> listOrdersByUserId(@PathVariable(value = "userId") String userId) throws Exception {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<OrdersVo> ordersVoList = ordersService.listOrdersByUserId(userId);
        if (ordersVoList != null) {
            return ResultUtils.success(ordersVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取用户订单列表失败");
        }
    }

    @PostMapping("/newOrders/{orders}")
    public BaseResponse<Integer> createOrders(@PathVariable(value = "orders") Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getBusinessId() == null || orders.getDaId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (orders.getOrderTotal() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "订单总支付价格不能小于零");
        }
        Integer result = ordersService.createOrders(orders);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新增订单失败");
        }
    }

    @PostMapping("/newStates/{orders}")
    public BaseResponse<Integer> updateOrder(@PathVariable(value = "orders") Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderState() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = ordersService.updateOrder(orders.getOrderId(), orders.getOrderState());
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新订单支付状态失败");
        }
    }

    @PostMapping("/newTotals/{orders}")
    public BaseResponse<Integer> updateOrders(@PathVariable(value = "orders") Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (orders.getOrderTotal() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "订单总支付价格不能小于零");
        }
        Integer result = ordersService.updateOrders(orders.getOrderId(), orders.getOrderTotal());
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新订单支付价格（因为更新了积分使用）失败");
        }
    }
}