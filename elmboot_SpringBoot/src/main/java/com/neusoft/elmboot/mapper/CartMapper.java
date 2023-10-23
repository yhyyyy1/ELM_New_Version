package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.model.dto.cart.CartEditRequest;
import com.neusoft.elmboot.model.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * @author 14505
 * @description 针对表【cart】的数据库操作Mapper
 * @createDate 2023-10-12 13:00:55
 * @Entity com.neusoft.elmboot.po.Cart
 */
public interface CartMapper extends BaseMapper<Cart> {

    @Delete("delete from cart where foodId = #{foodId} AND businessId = #{businessId} AND userId = #{userId}")
    public void removeCartWithFood(CartEditRequest cartEditRequest);

    @Delete("delete from cart where businessId = #{businessId} AND userId = #{userId}")
    public void removeCartWithoutFood(CartEditRequest cartEditRequest);
}




