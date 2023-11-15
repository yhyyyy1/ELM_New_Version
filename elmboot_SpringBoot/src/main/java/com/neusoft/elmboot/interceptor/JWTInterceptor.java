package com.neusoft.elmboot.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.elmboot.util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的令牌
        String token = request.getHeader("token");
        Map<String, Object> map = new HashMap<>();
        try {
            JWTUtil.verify(token); // 验证Token
            return true;
        } catch (TokenExpiredException e) {
            map.put("state", false);
            map.put("msg", "Token已经过期");
        } catch (SignatureVerificationException e) {
            map.put("state", false);
            map.put("msg", "签名错误");
        } catch (AlgorithmMismatchException e) {
            map.put("state", false);
            map.put("msg", "加密算法不匹配");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "无效token");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

}
