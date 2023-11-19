package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.bo.Orders;
import com.neusoft.elmboot.model.vo.OrdersVo;

public interface OrdersService {
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);

    public OrdersVo getOrdersById(Integer orderId);

    public List<OrdersVo> listOrdersByUserId(String userId);

    public int updateOrder(Integer orderId, Integer orderState);

    public int updateOrders(Integer orderId, Double orderTotal);
}
