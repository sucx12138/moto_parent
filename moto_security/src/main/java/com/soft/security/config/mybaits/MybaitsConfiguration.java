package com.soft.security.config.mybaits;

import com.soft.security.config.interceptor.MyBaitsInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/5/915:45
 */
@Configuration
@MapperScan({"com.soft.security.mapper"})
public class MybaitsConfiguration {
    /**
     * 注册mybaits 拦截器 拦截打印完整sql
     *
     * @return
     */
    @Bean
    public Interceptor getMyBaitsInterceptor() {
        return new MyBaitsInterceptor();
    }
}
