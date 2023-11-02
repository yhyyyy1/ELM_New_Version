package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import com.neusoft.elmboot.model.vo.CartVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.po.Cart;
import com.neusoft.elmboot.service.CartService;

@RestController
@RequestMapping("/CartController")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/listCart")
    public List<CartVo> listCart(Cart cart) throws Exception {
        if (cart.getCartId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return cartService.listCart(cart);
    }

    @RequestMapping("/saveCart")
    public int saveCart(Cart cart) throws Exception {
        if (cart.getUserId() == null || cart.getBusinessId() == null || cart.getFoodId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return cartService.saveCart(cart);
    }

    @RequestMapping("/updateCart")
    public int updateCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null || cart.getQuantity() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return cartService.updateCart(cart);
    }

    @RequestMapping("/removeCart")

    public int removeCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return cartService.removeCart(cart);
    }
}
