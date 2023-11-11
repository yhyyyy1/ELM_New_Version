package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.UserMapper;
import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVo getUserByIdByPass(User user) {
        User user1 = userMapper.getUserByIdByPass(user);
        return getUserVO(user1);
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
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    public int updatePoint(User user) {
        return userMapper.updatePoint(user);
    }

    public double getPointById(String userId) {
        return userMapper.getPointById(userId);
    }
}