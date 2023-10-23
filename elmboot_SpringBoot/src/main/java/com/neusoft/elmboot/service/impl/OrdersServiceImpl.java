package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.OrderdetailetMapper;
import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.dto.cart.CartQueryRequest;
import com.neusoft.elmboot.model.dto.orders.OrdersAddRequest;
import com.neusoft.elmboot.model.dto.orders.OrdersQueryRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.neusoft.elmboot.model.entity.Orderdetailet;
import com.neusoft.elmboot.model.entity.Orders;
import com.neusoft.elmboot.model.vo.CartVo;
import com.neusoft.elmboot.model.vo.OrdersVo;
import com.neusoft.elmboot.service.CartService;
import com.neusoft.elmboot.service.OrdersService;
import com.neusoft.elmboot.mapper.OrdersMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 14505
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:40
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

    @Resource
    private CartService cartService;

    @Resource
    private OrderdetailetMapper orderdetailetMapper;

    /**
     * 更新订单——更新订单金额 & 订单的积分使用
     *
     * @param orderId
     * @param orderTotal
     * @return
     */
    @Override
    public int updateOrders(Integer orderId, BigDecimal orderTotal) {
        Orders orders = this.baseMapper.selectById(orderId);
        if (orders == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Could not find");
        }

        orders.setOrderTotal(orderTotal);
        boolean result = this.updateById(orders);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
        }
        return 1;
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
        Orders orders = this.baseMapper.selectById(orderId);
        if (orders == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Could not find");
        }

        orders.setOrderState(orderState);
        boolean result = this.updateById(orders);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
        }
        return 1;
    }

    /**
     * 获得某个用户的所有订单
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrdersVo> listOrdersByUserId(String userId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>();
        queryWrapper.eq("userId", userId);
        List<Orders> ordersList = this.baseMapper.selectList(queryWrapper);
        return getOrdersVo(ordersList);
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public OrdersVo getOrdersById(Integer orderId) {
        Orders orders = this.baseMapper.selectById(orderId);
        return getOrdersVo(orders);
    }

    /**
     * 创建订单
     *
     * @param ordersAddRequest
     * @return
     */
    @Override
    public int createOrders(OrdersAddRequest ordersAddRequest) {
        Integer daId = ordersAddRequest.getDaId();
        String userId = ordersAddRequest.getUserId();
        Integer businessId = ordersAddRequest.getBusinessId();
        BigDecimal orderTotal = ordersAddRequest.getOrderTotal();


        //1. 查询当前用户购物车中当前商家的所有食品
        CartQueryRequest cartQueryRequest = new CartQueryRequest();
        cartQueryRequest.setUserId(userId);
        cartQueryRequest.setBusinessId(businessId);
        List<CartVo> cartList = cartService.listCart(cartQueryRequest);

        //2. 创建订单（生成返回的订单编号）
        //获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);

        // 新Orders
        Orders orders = new Orders();
        orders.setDaId(daId);
        orders.setUserId(userId);
        orders.setBusinessId(businessId);
        orders.setOrderDate(formattedDate);
        orders.setOrderTotal(orderTotal);
        orders.setOrderState(0);
        this.baseMapper.saveOrders(orders);
        Integer orderId = orders.getOrderId();

        //3. 批量添加订单明细——OrderDetail
        for (CartVo c : cartList) {
            Orderdetailet od = new Orderdetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            orderdetailetMapper.saveOrderDetailet(od);
        }

        //4. 从购物车中删除相关食品信息
        CartEditRequest cartEditRequest = new CartEditRequest();
        cartEditRequest.setBusinessId(businessId);
        cartEditRequest.setUserId(userId);
        cartService.removeCart(cartEditRequest);

        return orderId;
    }

    @Override
    public QueryWrapper<Orders> getQueryWrapper(OrdersQueryRequest ordersQueryRequest) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        if (ordersQueryRequest == null) {
            return null;
        }
        Integer orderId = ordersQueryRequest.getOrderId();
        String userId = ordersQueryRequest.getUserId();

        queryWrapper.eq(ObjectUtils.isNotEmpty(orderId), "orderId", orderId);
        queryWrapper.eq(StringUtils.isNotBlank(userId), "userId", userId);
        return queryWrapper;
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




