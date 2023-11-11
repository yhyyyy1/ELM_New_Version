package com.neusoft.elmboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.neusoft.elmboot.model.bo.Business;

@Mapper
public interface BusinessMapper {
    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId);

    @Select("SELECT * FROM business WHERE businessName LIKE CONCAT('%', #{businessName}, '%')")
    List<Business> listBusinessByBusinessName(String businessName);
}
