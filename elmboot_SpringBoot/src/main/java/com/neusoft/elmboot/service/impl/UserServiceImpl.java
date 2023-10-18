package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.mapper.UserMapper;
import com.neusoft.elmboot.model.dto.user.UserAddRequest;
import com.neusoft.elmboot.model.dto.user.UserLoginRequest;
import com.neusoft.elmboot.model.dto.user.UserUpdateRequest;
import com.neusoft.elmboot.model.entity.User;
import com.neusoft.elmboot.model.vo.UserVo;
import com.neusoft.elmboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 14505
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    /**
     * 通过id&密码获取用户——登录
     *
     * @param userLoginRequest
     * @return
     */
    @Override
    public UserVo getUserByIdByPass(UserLoginRequest userLoginRequest) {
        return null;
    }

    /**
     * 通过UserId获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public int getUserById(String userId) {
        return 0;
    }

    /**
     * 用户注册
     *
     * @param userAddRequest
     * @return
     */
    @Override
    public int saveUser(UserAddRequest userAddRequest) {
        return 0;
    }

    /**
     * 用户积分更新
     *
     * @param userUpdateRequest
     * @return
     */
    @Override
    public int updatePoint(UserUpdateRequest userUpdateRequest) {
        return 0;
    }

    /**
     * 获取用户积分
     *
     * @param userId
     * @return
     */
    @Override
    public double getPointById(String userId) {
        return 0;
    }
}




