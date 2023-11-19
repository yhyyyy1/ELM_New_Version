package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neusoft.elmboot.model.bo.Cart;
import com.neusoft.elmboot.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/lists")
    public BaseResponse<List<CartVo>> listCart(@RequestParam("cartId") Integer cartId,
                                               @RequestParam("userId") String userId,
                                               @RequestParam("businessId") Integer businessId) throws Exception {
        if (cartId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<CartVo> cartVoList = cartService.listCart(cartId, userId, businessId);
        if (cartVoList != null) {
            return ResultUtils.success(cartVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取购物车列表失败");
        }
    }

    @PostMapping("/newCarts")
    public BaseResponse<Integer> saveCart(@RequestParam("cartId") Integer cartId,
                                          @RequestParam("businessId") Integer businessId,
                                          @RequestParam("foodId") Integer foodId) throws Exception {
        if (cartId == null || businessId == null || foodId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = cartService.saveCart(cartId, businessId, foodId);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新增购物车失败");
        }
    }

    @PostMapping("/updated-carts")
    public BaseResponse<Integer> updateCart(@RequestParam("businessId") Integer businessId,
                                            @RequestParam("foodId") Integer foodId,
                                            @RequestParam("userId") String userId,
                                            @RequestParam("quantity") Integer quantity) throws Exception {
        if (businessId == null || foodId == null || userId == null || quantity == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (quantity <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "商品数量不可为空");
        }
        Integer result = cartService.updateCart(businessId, foodId, userId, quantity);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新购物车失败");
        }
    }

    @DeleteMapping
    public BaseResponse<Integer> removeCart(@RequestParam("userId") String userId,
                                            @RequestParam("businessId") Integer businessId,
                                            @RequestParam("foodId") Integer foodId) throws Exception {
        if (userId == null || businessId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = cartService.removeCart(userId, businessId, foodId);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，移除购物车失败");
        }
    }
}
