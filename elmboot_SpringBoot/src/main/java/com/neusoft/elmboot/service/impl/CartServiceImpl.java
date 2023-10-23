package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.cart.CartAddRequest;
import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.dto.cart.CartQueryRequest;
import com.neusoft.elmboot.model.dto.cart.CartUpdateRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.neusoft.elmboot.model.vo.CartVo;
import com.neusoft.elmboot.service.CartService;
import com.neusoft.elmboot.mapper.CartMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 14505
 * @description 针对表【cart】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:55
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {

    @Resource
    private CartMapper cartMapper;

    /**
     * 列出购物车内容
     *
     * @param cartQueryRequest
     * @return
     */
    @Override
    public List<CartVo> listCart(CartQueryRequest cartQueryRequest) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>();
        String userId = cartQueryRequest.getUserId();
        Integer businessId = cartQueryRequest.getBusinessId();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("businessId", businessId);
        List<Cart> cartList = this.baseMapper.selectList(queryWrapper);
        return getCartVo(cartList);
    }

    private Cart getCart(CartQueryRequest cartQueryRequest) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>();
        String userId = cartQueryRequest.getUserId();
        Integer businessId = cartQueryRequest.getBusinessId();
        Integer foodId = cartQueryRequest.getFoodId();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("businessId", businessId);
        queryWrapper.eq("foodId", foodId);
        Cart cart = this.baseMapper.selectOne(queryWrapper);
        return cart;
    }

    /**
     * 新建购物车
     *
     * @param cartAddRequest
     * @return
     */
    @Override
    public int saveCart(CartAddRequest cartAddRequest) {
        Integer foodId = cartAddRequest.getFoodId();
        Integer businessId = cartAddRequest.getBusinessId();
        String userId = cartAddRequest.getUserId();

        //插入数据
        Cart cart = new Cart();
        cart.setFoodId(foodId);
        cart.setBusinessId(businessId);
        cart.setUserId(userId);
        cart.setQuantity(1);
        boolean result = this.save(cart);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "购物车新建失败，数据库错误");
        }
        return 1;
    }

    /**
     * 更新购物车
     *
     * @param cartUpdateRequest
     * @return
     */
    @Override
    public int updateCart(CartUpdateRequest cartUpdateRequest) {
        Integer foodId = cartUpdateRequest.getFoodId();
        Integer businessId = cartUpdateRequest.getBusinessId();
        String userId = cartUpdateRequest.getUserId();
        Integer quantity = cartUpdateRequest.getQuantity();

        //先查询出对应的购物车
        CartQueryRequest cartQueryRequest = new CartQueryRequest();
        cartQueryRequest.setUserId(userId);
        cartQueryRequest.setBusinessId(businessId);
        cartQueryRequest.setFoodId(foodId);
        Cart cart = getCart(cartQueryRequest);
        if (cart == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "Could not find");
        }
        cart.setQuantity(quantity);
        boolean result = this.updateById(cart);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
        }
        return 1;
    }

    /**
     * 移除购物车
     *
     * @param cartEditRequest
     * @return
     */
    @Override
    public int removeCart(CartEditRequest cartEditRequest) {
        Integer foodId = cartEditRequest.getFoodId();
        Integer businessId = cartEditRequest.getBusinessId();
        String userId = cartEditRequest.getUserId();

        if (foodId == null) {
            CartEditRequest cartEditRequestNew = new CartEditRequest();
            cartEditRequestNew.setUserId(userId);
            cartEditRequestNew.setBusinessId(businessId);
            cartMapper.removeCartWithoutFood(cartEditRequestNew);
            return 1;
        } else {
            //先查询出对应的购物车
            CartQueryRequest cartQueryRequest = new CartQueryRequest();
            cartQueryRequest.setUserId(userId);
            cartQueryRequest.setBusinessId(businessId);
            cartQueryRequest.setFoodId(foodId);
            Cart cart = getCart(cartQueryRequest);
            if (cart == null) {
                throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "Could not find");
            }
            boolean result = this.removeById(cart);
            if (!result) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
            }
            return 1;
        }
    }

    public CartVo getCartVo(Cart cart) {
        if (cart == null) {
            return null;
        }
        CartVo cartVo = new CartVo();
        BeanUtils.copyProperties(cart, cartVo);
        return cartVo;
    }

    public List<CartVo> getCartVo(List<Cart> cartList) {
        if (CollectionUtils.isEmpty(cartList)) {
            return new ArrayList<>();
        }
        return cartList.stream().map(this::getCartVo).collect(Collectors.toList());
    }

    /**
     * 实体对象封装操作类
     *
     * @param cartQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<Cart> getQueryWrapper(CartQueryRequest cartQueryRequest) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        if (cartQueryRequest == null) {
            return null;
        }

        String userId = cartQueryRequest.getUserId();
        Integer businessId = cartQueryRequest.getBusinessId();
        Integer foodId = cartQueryRequest.getFoodId();
        // 拼接查询条件
        queryWrapper.eq(StringUtils.isNotBlank(userId), "userId", userId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(businessId), "businessId", businessId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(foodId), "foodId", foodId);
        return queryWrapper;
    }
}




