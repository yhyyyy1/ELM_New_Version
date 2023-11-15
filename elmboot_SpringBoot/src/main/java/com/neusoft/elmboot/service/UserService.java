package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.model.vo.UserVo;

public interface UserService {
    public UserVo getUserByIdByPass(User user);

    public int getUserById(String userId);

    public int saveUser(User user);

}
