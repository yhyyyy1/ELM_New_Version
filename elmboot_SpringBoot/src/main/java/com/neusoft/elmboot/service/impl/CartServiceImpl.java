package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.dto.cart.CartAddRequest;
import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.dto.cart.CartQueryRequest;
import com.neusoft.elmboot.model.dto.cart.CartUpdateRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.neusoft.elmboot.model.vo.CartVo;
import com.neusoft.elmboot.service.CartService;
import com.neusoft.elmboot.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 14505
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2023-10-12 13:00:55
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

    /**
     * 列出购物车内容
     * @param cartQueryRequest
     * @return
     */
    @Override
    public List<CartVo> listCart(CartQueryRequest cartQueryRequest) {
        return null;
    }

    /**
     * 新建购物车
     * @param cartAddRequest
     * @return
     */
    @Override
    public int saveCart(CartAddRequest cartAddRequest) {
        return 0;
    }

    /**
     * 更新购物车
     * @param cartUpdateRequest
     * @return
     */
    @Override
    public int updateCart(CartUpdateRequest cartUpdateRequest) {
        return 0;
    }

    /**
     * 移除购物车
     * @param cartEditRequest
     * @return
     */
    @Override
    public int removeCart(CartEditRequest cartEditRequest) {
        return 0;
    }
}




