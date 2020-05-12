package com.soft.security.config.common;

import com.soft.common.aop.CommonControllerAspect;
import com.soft.common.aop.CommonModelAspect;
import com.soft.common.utils.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/5/129:21
 */
@Configuration
public class CommonConfiguration {
    /**
     * 控制层日志实现
     * @return
     */
    @Bean
    public CommonControllerAspect controllerAspect(){
        return new CommonControllerAspect();
    }

    /**
     * 基础数据封装切面实现
     * @return
     */
    @Bean
    public CommonModelAspect modelAspect(){
        return new CommonModelAspect();
    }

    /**
     * 基础数据封装切面实现
     * @return
     */
    @Bean
    public JwtTokenUtil jwtTokenUtil(){
        return new JwtTokenUtil();
    }
}
