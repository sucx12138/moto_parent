package com.soft.security.config.security.handler;


import com.alibaba.fastjson.JSONObject;
import com.soft.common.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author sucx
 * @projectName moto
 * @description: 登陆失败处理
 * @date 2020/4/2115:15
 */
@Slf4j
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info(e.getMessage());
        //将 登录失败 信息打包成json格式返回
        response.setContentType("application/json;charset=UTF-8");
        ApiError apiError = new ApiError(BAD_REQUEST.value(),"用户名密码错误...");
        response.getWriter().write(JSONObject.toJSONString(apiError));
    }
}
