package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.dto.cart.CartAddRequest;
import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.dto.cart.CartQueryRequest;
import com.neusoft.elmboot.model.dto.cart.CartUpdateRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.CartVo;

import java.util.List;

/**
* @author 14505
* @description 针对表【cart】的数据库操作Service
* @createDate 2023-10-12 13:00:55
*/
public interface CartService extends IService<Cart> {
    /**
     * 列出购物车内容
     * @param cartQueryRequest
     * @return
     */
    List<CartVo> listCart(CartQueryRequest cartQueryRequest);

    /**
     * 新建购物车
     * @param cartAddRequest
     * @return
     */
    int saveCart(CartAddRequest cartAddRequest);

    /**
     * 更新购物车
     * @param cartUpdateRequest
     * @return
     */
    int updateCart(CartUpdateRequest cartUpdateRequest);

    /**
     * 移除购物车
     * @param cartEditRequest
     * @return
     */
    int removeCart(CartEditRequest cartEditRequest);
}
