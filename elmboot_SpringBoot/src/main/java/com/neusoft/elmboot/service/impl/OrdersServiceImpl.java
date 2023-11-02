package com.neusoft.elmboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.neusoft.elmboot.model.vo.OrdersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.elmboot.mapper.CartMapper;
import com.neusoft.elmboot.mapper.OrderDetailetMapper;
import com.neusoft.elmboot.mapper.OrdersMapper;
import com.neusoft.elmboot.model.po.Cart;
import com.neusoft.elmboot.model.po.OrderDetailet;
import com.neusoft.elmboot.model.po.Orders;
import com.neusoft.elmboot.service.OrdersService;
import com.neusoft.elmboot.util.CommonUtil;
import org.springframework.util.CollectionUtils;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        //1、查询当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> cartList = cartMapper.listCart(cart);


        //2、创建订单（返回生成的订单编号）
        orders.setOrderDate(CommonUtil.getCurrentDate());
        ordersMapper.saveOrders(orders);
        int orderId = orders.getOrderId();

        //3、批量添加订单明细
        List<OrderDetailet> list = new ArrayList<>();
        for (Cart c : cartList) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            list.add(od);
        }
        orderDetailetMapper.saveOrderDetailetBatch(list);

        //4、从购物车表中删除相关食品信息
        cartMapper.removeCart(cart);

        return orderId;
    }

    @Override
    public OrdersVo getOrdersById(Integer orderId) {
        Orders orders = ordersMapper.getOrdersById(orderId);
        return getOrdersVo(orders);
    }

    @Override
    public List<OrdersVo> listOrdersByUserId(String userId) {
        List<Orders> ordersList = ordersMapper.listOrdersByUserId(userId);
        return getOrdersVo(ordersList);
    }

    public int updateOrder(Integer orderId, Integer orderState) {
        return ordersMapper.updateOrder(orderId, orderState);
    }

    @Override
    public int updateOrders(Integer orderId, Double orderTotal) {
        return ordersMapper.updateOrders(orderId, orderTotal);
    }

    public OrdersVo getOrdersVo(Orders orders) {
        if (orders == null) {
            return null;
        }
        OrdersVo ordersVo = new OrdersVo();
        BeanUtils.copyProperties(orders, ordersVo);
        return ordersVo;
    }


    public List<OrdersVo> getOrdersVo(List<Orders> ordersList) {
        if (CollectionUtils.isEmpty(ordersList)) {
            return new ArrayList<>();
        }
        return ordersList.stream().map(this::getOrdersVo).collect(Collectors.toList());
    }
}
