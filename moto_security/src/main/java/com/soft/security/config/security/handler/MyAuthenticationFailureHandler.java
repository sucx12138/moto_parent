package com.soft.security.config.security.handler;


import com.alibaba.fastjson.JSONObject;
import com.soft.common.enums.LoginType;
import com.soft.common.model.ApiError;
import com.soft.security.config.properties.MySecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MySecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info("登录失败");
        //如果是json 格式
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //将 登录失败 信息打包成json格式返回
            response.setContentType("application/json;charset=UTF-8");
            ApiError apiError = new ApiError(BAD_REQUEST.value(),e.getMessage());
            response.getWriter().write(JSONObject.toJSONString(apiError));
        }else{
            //如果不是json格式，返回view
            super.onAuthenticationFailure(request,response,e);
        }

    }
}
