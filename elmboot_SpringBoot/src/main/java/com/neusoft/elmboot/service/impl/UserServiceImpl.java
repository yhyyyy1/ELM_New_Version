package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.UserMapper;
import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.service.UserService;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointMapper pointMapper;

    @Override
    public UserVo getUserByIdByPass(User user) {
        try {
            User user1 = userMapper.getUserByIdByPass(user);
            return getUserVO(user1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserVo getUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

    @Override
    public int getUserById(String userId) {
        try {
            return userMapper.getUserById(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int saveUser(User user) {
        try {
            pointMapper.savePoint(user.getUserId());
            return userMapper.saveUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}