package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.bo.Cart;
import com.neusoft.elmboot.service.CartService;

@RestController
@RequestMapping("/CartController")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/listCart")
    public BaseResponse<List<CartVo>> listCart(Cart cart) throws Exception {
        if (cart.getCartId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<CartVo> cartVoList = cartService.listCart(cart);
        return ResultUtils.success(cartVoList);
    }

    @RequestMapping("/saveCart")
    public BaseResponse<Integer> saveCart(Cart cart) throws Exception {
        if (cart.getUserId() == null || cart.getBusinessId() == null || cart.getFoodId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = cartService.saveCart(cart);
        return ResultUtils.success(result);
    }

    @RequestMapping("/updateCart")
    public BaseResponse<Integer> updateCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null || cart.getQuantity() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = cartService.updateCart(cart);
        return ResultUtils.success(result);
    }

    @RequestMapping("/removeCart")

    public BaseResponse<Integer> removeCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        Integer result = cartService.removeCart(cart);
        return ResultUtils.success(result);
    }
}
