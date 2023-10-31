package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.model.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
* @author 14505
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-10-12 13:00:40
* @Entity com.neusoft.elmboot.model.entity.Orders
*/
public interface OrdersMapper extends BaseMapper<Orders> {

    @Insert("insert into orders(userId,businessId,orderDate,orderTotal,daId,orderState) values(#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    public void saveOrders(Orders orders);
}




