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
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<CartVo> cartVoList = cartService.listCart(cart);
        if (cartVoList != null) {
            return ResultUtils.success(cartVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取购物车列表失败");
        }
    }

    @RequestMapping("/saveCart")
    public BaseResponse<Integer> saveCart(Cart cart) throws Exception {
        if (cart.getUserId() == null || cart.getBusinessId() == null || cart.getFoodId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = cartService.saveCart(cart);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新增购物车失败");
        }
    }

    @RequestMapping("/updateCart")
    public BaseResponse<Integer> updateCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null || cart.getQuantity() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (cart.getQuantity() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "商品数量不可为空");
        }
        Integer result = cartService.updateCart(cart);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新购物车失败");
        }
    }

    @RequestMapping("/removeCart")
    public BaseResponse<Integer> removeCart(Cart cart) throws Exception {
        if (cart.getBusinessId() == null || cart.getFoodId() == null || cart.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = cartService.removeCart(cart);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，移除购物车失败");
        }
    }
}
