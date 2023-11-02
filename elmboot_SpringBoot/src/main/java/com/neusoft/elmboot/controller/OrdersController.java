package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import com.neusoft.elmboot.model.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.po.Orders;
import com.neusoft.elmboot.service.OrdersService;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/createOrders")
    public int createOrders(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getBusinessId() == null || orders.getDaId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ordersService.createOrders(orders);
    }

    @RequestMapping("/getOrdersById")
    public OrdersVo getOrdersById(Orders orders) throws Exception {
        if (orders.getOrderId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ordersService.getOrdersById(orders.getOrderId());
    }

    @RequestMapping("/listOrdersByUserId")
    public List<OrdersVo> listOrdersByUserId(Orders orders) throws Exception {
        if (orders.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ordersService.listOrdersByUserId(orders.getUserId());
    }

    @RequestMapping("/updateOrder")
    public int updateOrder(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderState() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ordersService.updateOrder(orders.getOrderId(), orders.getOrderState());
    }

    @RequestMapping("/updateOrders")
    public int updateOrders(Orders orders) throws Exception {
        if (orders.getUserId() == null || orders.getOrderTotal() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ordersService.updateOrders(orders.getOrderId(), orders.getOrderTotal());
    }
}