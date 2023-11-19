package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.bo.Cart;
import com.neusoft.elmboot.model.vo.CartVo;
import org.springframework.web.bind.annotation.RequestParam;

public interface CartService {
    public List<CartVo> listCart(Integer cartId, String userId, Integer businessId);

    public int saveCart(Integer cartId, Integer businessId, Integer foodId);

    public int updateCart(Integer businessId, Integer foodId, String userId, Integer quantity);

    public int removeCart(String userId, Integer businessId, Integer foodId);
}
