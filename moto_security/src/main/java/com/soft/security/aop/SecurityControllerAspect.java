package com.soft.security.aop;

import com.soft.common.aop.CommonControllerAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sucx
 * @title: ControllerlAspect
 * @projectName springboot_demo
 * @description: controller 切面日志记录
 * @date 2020/1/2211:08
 */
@Component
@Slf4j
@Aspect
public class SecurityControllerAspect {

    @Autowired
    private CommonControllerAspect commonControllerAspect;

    @Autowired

    @Pointcut("execution(public * com.soft.*.controller..*.*(..))")
    public void webLog(){}


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        commonControllerAspect.doBefore(joinPoint);
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容
        commonControllerAspect.doAfterReturning(ret);
    }
}
