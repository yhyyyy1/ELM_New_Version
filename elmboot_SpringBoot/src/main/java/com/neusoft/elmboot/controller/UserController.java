package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import com.neusoft.elmboot.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.po.User;
import com.neusoft.elmboot.service.UserService;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUserByIdByPass")
    public UserVo getUserByIdByPass(User user) throws Exception {
        if (StringUtils.isAnyBlank(user.getUserId(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return userService.getUserByIdByPass(user);
    }

    /**
     * 避免重复用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserById")
    public int getUserById(User user) throws Exception {
        if (StringUtils.isEmpty(user.getUserId())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return userService.getUserById(user.getUserId());
    }

    @RequestMapping("/saveUser")
    public int saveUser(User user) throws Exception {
        if (StringUtils.isAnyBlank(user.getUserId(), user.getPassword(), user.getUserName()) || user.getPassword() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return userService.saveUser(user);
    }

    @RequestMapping("/updatePoint")
    public int updatePoint(User user) throws Exception {
        if (user.getUserId() == null || user.getPoint() <= 0) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return userService.updatePoint(user);
    }

    @RequestMapping("/getPointById")
    public double getPointById(User user) throws Exception {
        if (user.getUserId() == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return userService.getPointById(user.getUserId());
    }
}
