package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.dto.orders.OrdersAddRequest;
import com.neusoft.elmboot.model.entity.Orders;
import com.neusoft.elmboot.model.vo.OrdersVo;
import com.neusoft.elmboot.service.OrdersService;
import com.neusoft.elmboot.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 14505
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:40
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

    /**
     * 更新订单——更新订单金额 & 订单的积分使用
     *
     * @param orderId
     * @param orderTotal
     * @return
     */
    @Override
    public int updateOrders(Integer orderId, BigDecimal orderTotal) {
        return 0;
    }

    /**
     * 更新订单——更新支付状态
     *
     * @param orderId
     * @param orderState
     * @return
     */
    @Override
    public int updateOrder(Integer orderId, Integer orderState) {
        return 0;
    }

    /**
     * 获得某个用户的所有订单
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrdersVo> listOrdersByUserId(String userId) {
        return null;
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public OrdersVo getOrdersById(Integer orderId) {
        return null;
    }

    /**
     * 创建订单
     *
     * @param ordersAddRequest
     * @return
     */
    @Override
    public int createOrders(OrdersAddRequest ordersAddRequest) {
        return 0;
    }
}




