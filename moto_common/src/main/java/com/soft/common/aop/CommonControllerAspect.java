package com.soft.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author sucx
 * @title: ControllerlAspect
 * @projectName springboot_demo
 * @description: controller 切面日志记录
 * @date 2020/1/2211:08
 */
@Slf4j
public class CommonControllerAspect {

    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("REQUEST_ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }
}
