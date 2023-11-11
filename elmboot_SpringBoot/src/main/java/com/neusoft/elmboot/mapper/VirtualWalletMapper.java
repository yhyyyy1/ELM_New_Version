package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.model.bo.VirtualWallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

@Mapper
public interface VirtualWalletMapper {
    @Select("select * from virtualwallet where userId = #{userId}")
    VirtualWallet getVirtualWallet(String userId) throws SQLException;

    @Update("update virtualwallet set amount = #{amount} where userId = #{userId}")
    public int updateVirtualWallet(String userId, Integer amount) throws SQLException;
}
