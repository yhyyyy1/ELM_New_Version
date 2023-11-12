package com.neusoft.elmboot.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.neusoft.elmboot.model.vo.CartVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.CartMapper;
import com.neusoft.elmboot.model.bo.Cart;
import com.neusoft.elmboot.service.CartService;
import org.springframework.util.CollectionUtils;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<CartVo> listCart(Cart cart) {
        List<Cart> cartList = cartMapper.listCart(cart);
        return getCartVo(cartList);
    }

    @Override
    public int saveCart(Cart cart) {
        try {
            return cartMapper.saveCart(cart);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateCart(Cart cart) {
        try {
            return cartMapper.updateCart(cart);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int removeCart(Cart cart) {
        try {
            return cartMapper.removeCart(cart);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
}
