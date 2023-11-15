package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.bo.User;
import com.neusoft.elmboot.model.vo.UserVo;

import java.util.Map;

public interface UserService {
    public Map<String, String> getUserByIdByPass(User user);

    public int getUserById(String userId);

    public int saveUser(User user);

}
