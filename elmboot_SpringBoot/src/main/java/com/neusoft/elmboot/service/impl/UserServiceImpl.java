package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.UserMapper;
import com.neusoft.elmboot.model.dto.user.UserAddRequest;
import com.neusoft.elmboot.model.dto.user.UserLoginRequest;
import com.neusoft.elmboot.model.dto.user.UserQueryRequest;
import com.neusoft.elmboot.model.dto.user.UserUpdateRequest;
import com.neusoft.elmboot.model.entity.User;
import com.neusoft.elmboot.model.entity.User;
import com.neusoft.elmboot.model.vo.UserVo;
import com.neusoft.elmboot.model.vo.UserVo;
import com.neusoft.elmboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        String userId = userLoginRequest.getUserId();
        String password = userLoginRequest.getPassword();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("password", password);
        User user = this.baseMapper.selectOne(queryWrapper);
        return getUserVo(user);
    }

    /**
     * 通过UserId获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public int getUserById(String userId) {
        User user = this.baseMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "User not found");
        } else {
            return 1;
        }
    }

    /**
     * 用户注册
     *
     * @param userAddRequest
     * @return
     */
    @Override
    public int saveUser(UserAddRequest userAddRequest) {
        String userId = userAddRequest.getUserId();
        String password = userAddRequest.getPassword();
        String userName = userAddRequest.getUserName();
        Integer userSex = userAddRequest.getUserSex();
        String userImg = userAddRequest.getUserImg();

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setUserImg(userImg);
        user.setDelTag(1);
        user.setPoint((double) 0);

        boolean result = this.save(user);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "用户创建失败，数据库错误");
        }
        return 1;
    }

    /**
     * 用户积分更新
     *
     * @param userUpdateRequest
     * @return
     */
    @Override
    public int updatePoint(UserUpdateRequest userUpdateRequest) {
        String userId = userUpdateRequest.getUserId();
        Double point = userUpdateRequest.getPoint();

        User user = this.baseMapper.selectById(userId);
        user.setPoint(point);
        boolean result = this.updateById(user);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Update Database failed");
        }
        return 1;
    }

    /**
     * 获取用户积分
     *
     * @param userId
     * @return
     */
    @Override
    public double getPointById(String userId) {
        User user = this.baseMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "User not found");
        } else {
            return user.getPoint();
        }
    }

    @Override
    public QueryWrapper<User> getQueryWraapper(UserQueryRequest userQueryRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userQueryRequest == null) {
            return null;
        }
        String userId = userQueryRequest.getUserId();
        queryWrapper.eq(StringUtils.isNotBlank(userId), "userId", userId);
        return queryWrapper;
    }

    public UserVo getUserVo(User user) {
        if (user == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}




