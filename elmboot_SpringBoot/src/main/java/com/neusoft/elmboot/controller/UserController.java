package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.user.UserAddRequest;
import com.neusoft.elmboot.model.dto.user.UserLoginRequest;
import com.neusoft.elmboot.model.dto.user.UserQueryRequest;
import com.neusoft.elmboot.model.dto.user.UserUpdateRequest;
import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/UserController")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 通过id&密码获取用户——登录
     *
     * @param userLoginRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserByIdByPass")
    public BaseResponse<UserVo> getUserByIdByPass(UserLoginRequest userLoginRequest) throws Exception {
        if (userLoginRequest.getUserId() == null || userLoginRequest.getPassword() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserVo user = userService.getUserByIdByPass(userLoginRequest);
        if (user == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(user);
    }

    /**
     * 通过UserId获取用户信息
     *
     * @param userQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserById")
    public BaseResponse<Integer> getUserById(UserQueryRequest userQueryRequest) throws Exception {
        if (userQueryRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer result = userService.getUserById(userQueryRequest.getUserId());
        return ResultUtils.success(result);
    }

    /**
     * 用户注册
     *
     * @param userAddRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUser")
    public BaseResponse<Integer> saveUser(UserAddRequest userAddRequest) throws Exception {
        if (userAddRequest.getUserName() == null || userAddRequest.getUserSex() == null ||
                userAddRequest.getPassword() == null || userAddRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
//        if(userAddRequest.getUserImg() == null)
//        {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
        Integer result = userService.saveUser(userAddRequest);
        return ResultUtils.success(result);
    }

    /**
     * 用户积分更新
     *
     * @param userUpdateRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/updatePoint")
    public BaseResponse<Integer> updatePoint(UserUpdateRequest userUpdateRequest) throws Exception {
        Integer result = userService.updatePoint(userUpdateRequest);
        return ResultUtils.success(result);
    }

    /**
     * 获取用户积分
     *
     * @param userQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPointById")
    public BaseResponse<Double> getPointById(UserQueryRequest userQueryRequest) throws Exception {
        if (userQueryRequest.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Double point = userService.getPointById(userQueryRequest.getUserId());
        return ResultUtils.success(point);
    }
}
