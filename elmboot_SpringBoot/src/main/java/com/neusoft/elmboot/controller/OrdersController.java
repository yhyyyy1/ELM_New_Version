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

    @RequestMapping("/getOrdersById")
    public BaseResponse<OrdersVo> getOrdersById(Orders orders) throws Exception {
        if (orders.getOrderId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        OrdersVo ordersVo = ordersService.getOrdersById(orders.getOrderId());
        if (ordersVo != null) {
            return ResultUtils.success(ordersVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取订单失败");
        }
    }

    @RequestMapping("/listOrdersByUserId")
    public BaseResponse<List<OrdersVo>> listOrdersByUserId(Orders orders) throws Exception {
        if (orders.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<OrdersVo> ordersVoList = ordersService.listOrdersByUserId(orders.getUserId());
        if (ordersVoList != null) {
            return ResultUtils.success(ordersVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取用户订单列表失败");
        }
    }

    @RequestMapping("/updateOrder")
    public BaseResponse<Integer> updateOrder(Orders orders) throws Exception {
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

    @RequestMapping("/updateOrders")
    public BaseResponse<Integer> updateOrders(Orders orders) throws Exception {
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