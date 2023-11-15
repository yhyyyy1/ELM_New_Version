package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.neusoft.elmboot.model.bo.User;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public User getUserByIdByPass(User user) throws SQLException;
    //明显比JDBC的要方便很多，不需要额外的改了

    @Select("select count(*) from user where userId=#{userId}")
    public int getUserById(String userId) throws SQLException;

    @Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},null,1,0)")
    public int saveUser(User user) throws SQLException;

}