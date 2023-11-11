package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.bo.Cart;
import com.neusoft.elmboot.model.vo.CartVo;

public interface CartService {
    public List<CartVo> listCart(Cart cart);

    public int saveCart(Cart cart);

    public int updateCart(Cart cart);

    public int removeCart(Cart cart);
}
