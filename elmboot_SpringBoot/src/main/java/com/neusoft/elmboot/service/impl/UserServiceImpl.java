package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.model.vo.UserVo;
import com.neusoft.elmboot.util.JWTUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.UserMapper;
import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointMapper pointMapper;

    @Override
    public Map<String, String> getUserByIdByPass(User user) {
        try {
            User user1 = userMapper.getUserByIdByPass(user);
            if (user1 == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "数据库操作失败，用户登录失败");
            }

            //获取Token
            Map<String, String> claim = new HashMap<String, String>();
            claim.put("user", user.getUserId());
            JWTUtil jwtUtil = new JWTUtil();
            String token = jwtUtil.getToken(claim);

            Map<String, String> jwtMap = new HashMap<String, String>();
            jwtMap.put("JWT", token);
            return jwtMap;
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