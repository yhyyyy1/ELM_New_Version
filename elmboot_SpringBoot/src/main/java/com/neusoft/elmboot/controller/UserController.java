package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.service.UserService;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUserByIdByPass")
    public BaseResponse<UserVo> getUserByIdByPass(User user) throws Exception {
        if (StringUtils.isAnyBlank(user.getUserId(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        UserVo userVo = userService.getUserByIdByPass(user);
        if (userVo != null) {
            return ResultUtils.success(userVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，用户登录失败");
        }
    }

    /**
     * 避免重复用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserById")
    public BaseResponse<Integer> getUserById(User user) throws Exception {
        if (StringUtils.isEmpty(user.getUserId())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = userService.getUserById(user.getUserId());
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询用户失败");
        }
    }

    @RequestMapping("/saveUser")
    public BaseResponse<Integer> saveUser(User user) throws Exception {
        if (StringUtils.isAnyBlank(user.getUserId(), user.getPassword(), user.getUserName()) || user.getPassword() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (user.getPassword().length() < 6) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码长度过短，应大于6位");
        }
        Integer result = userService.saveUser(user);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新增用户失败");
        }
    }

    @RequestMapping("/updatePoint")
    public BaseResponse<Integer> updatePoint(User user) throws Exception {
        if (user.getUserId() == null || user.getPoint() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = userService.updatePoint(user);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新用户积分失败");
        }
    }

    @RequestMapping("/getPointById")
    public BaseResponse<Double> getPointById(User user) throws Exception {
        if (user.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Double result = userService.getPointById(user.getUserId());
        if (result < 0) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新用户积分失败");
        }
    }
}
