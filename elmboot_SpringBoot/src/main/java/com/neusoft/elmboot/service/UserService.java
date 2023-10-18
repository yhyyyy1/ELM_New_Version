package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.dto.user.UserAddRequest;
import com.neusoft.elmboot.model.dto.user.UserLoginRequest;
import com.neusoft.elmboot.model.dto.user.UserUpdateRequest;
import com.neusoft.elmboot.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.UserVo;

/**
 * @author 14505
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-10-12 13:00:15
 */
public interface UserService extends IService<User> {

    /**
     * 通过id&密码获取用户——登录
     *
     * @param userLoginRequest
     * @return
     */
    UserVo getUserByIdByPass(UserLoginRequest userLoginRequest);

    /**
     * 通过UserId获取用户信息
     *
     * @param userId
     * @return
     */
    int getUserById(String userId);

    /**
     * 用户注册
     *
     * @param userAddRequest
     * @return
     */
    int saveUser(UserAddRequest userAddRequest);

    /**
     * 用户积分更新
     *
     * @param userUpdateRequest
     * @return
     */
    int updatePoint(UserUpdateRequest userUpdateRequest);

    /**
     * 获取用户积分
     *
     * @param userId
     * @return
     */
    double getPointById(String userId);
}
