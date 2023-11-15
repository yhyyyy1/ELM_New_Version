package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.service.UserService;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //todo 为什么要改成Post？
    //todo 修改返回类型，将JWT字符串作为登录成功的返回

    /**
     * 用户登录
     * 虽然没有涉及到业务数据的变化，但是登录还是要用post方法以掩盖敏感信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/logged-in-users")
    public BaseResponse<UserVo> getUserByIdByPass(@RequestParam("user") User user) throws Exception {
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
    @GetMapping("/{user}")
    public BaseResponse<Integer> getUserById(@PathVariable(value = "user") User user) throws Exception {
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

    @PostMapping("/newUsers/{user}")
    public BaseResponse<Integer> saveUser(@PathVariable(value = "user") User user) throws Exception {
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
}
