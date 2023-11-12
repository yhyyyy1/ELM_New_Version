package com.neusoft.elmboot.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.neusoft.elmboot.model.bo.OrderDetailet;

@Mapper
public interface OrderDetailetMapper {
    public void saveOrderDetailetBatch(List<OrderDetailet> list) throws SQLException;

    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderOd) throws SQLException;
}