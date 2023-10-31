package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.model.entity.Orderdetailet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * @author 14505
 * @description 针对表【orderdetailet】的数据库操作Mapper
 * @createDate 2023-10-12 13:00:46
 * @Entity com.neusoft.elmboot.model.entity.Orderdetailet
 */
public interface OrderdetailetMapper extends BaseMapper<Orderdetailet> {
    @Insert("insert into orderDetailet(orderId,foodId,quantity) values(#{od.orderId},#{od.foodId},#{od.quantity})")
    public void saveOrderDetailet(Orderdetailet orderDetailet);
}




