package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.dto.orders.OrdersAddRequest;
import com.neusoft.elmboot.model.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.OrdersVo;

import java.math.BigDecimal;
import java.util.List;

/**
* @author 14505
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-10-12 13:00:40
*/
public interface OrdersService extends IService<Orders> {

    /**
     * 更新订单——更新订单金额 & 订单的积分使用
     * @param orderId
     * @param orderTotal
     * @return
     */
    int updateOrders(Integer orderId, BigDecimal orderTotal);

    /**
     * 更新订单——更新支付状态
     * @param orderId
     * @param orderState
     * @return
     */
    int updateOrder(Integer orderId, Integer orderState);

    /**
     * 获得某个用户的所有订单
     * @param userId
     * @return
     */
    List<OrdersVo> listOrdersByUserId(String userId);

    /**
     * 根据订单ID获取订单信息
     * @param orderId
     * @return
     */
    OrdersVo getOrdersById(Integer orderId);

    /**
     * 创建订单
     * @param ordersAddRequest
     * @return
     */
    int createOrders(OrdersAddRequest ordersAddRequest);
}
