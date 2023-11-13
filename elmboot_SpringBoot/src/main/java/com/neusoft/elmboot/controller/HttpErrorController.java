package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class HttpErrorController {
    @RequestMapping(value = "/error", produces = {"application/json;charset=UTF-8"})
    public BaseResponse errorJson(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("error", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        map.put("massage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        return ResultUtils.error(ErrorCode.FAILURE, map.toString());
    }
}
