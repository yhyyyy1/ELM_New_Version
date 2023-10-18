package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.cart.CartAddRequest;
import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.dto.cart.CartQueryRequest;
import com.neusoft.elmboot.model.dto.cart.CartUpdateRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.neusoft.elmboot.model.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.CartService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/CartController")
public class CartController {
    @Resource
    private CartService cartService;

    /**
     * 列出购物车内容
     *
     * @param cartQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listCart")
    public BaseResponse<List<CartVo>> listCart(CartQueryRequest cartQueryRequest) throws Exception {
        if (cartQueryRequest.getBusinessId() == null || cartQueryRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<CartVo> listCartVo = cartService.listCart(cartQueryRequest);
        if (listCartVo.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(listCartVo);
    }

    /**
     * 新建购物车
     *
     * @param cartAddRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveCart")
    public BaseResponse<Integer> saveCart(CartAddRequest cartAddRequest) throws Exception {
        if (cartAddRequest.getBusinessId() == null || cartAddRequest.getUserId() == null || cartAddRequest.getFoodId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = cartService.saveCart(cartAddRequest);
        return ResultUtils.success(result);
    }

    /**
     * 更新购物车
     *
     * @param cartUpdateRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateCart")
    public BaseResponse<Integer> updateCart(CartUpdateRequest cartUpdateRequest) throws Exception {
        if (cartUpdateRequest.getBusinessId() == null || cartUpdateRequest.getUserId() == null ||
                cartUpdateRequest.getFoodId() == null || cartUpdateRequest.getQuantity() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = cartService.updateCart(cartUpdateRequest);
        return ResultUtils.success(result);
    }

    /**
     * 移除购物车
     *
     * @param cartEditRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/removeCart")
    public BaseResponse<Integer> removeCart(CartEditRequest cartEditRequest) throws Exception {
        if (cartEditRequest.getFoodId() == null || cartEditRequest.getUserId() == null || cartEditRequest.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = cartService.removeCart(cartEditRequest);
        return ResultUtils.success(result);
    }
}
