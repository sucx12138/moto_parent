package com.soft.security.config.security;

import com.soft.security.mapper.UserMapper;
import com.soft.security.model.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author sucx
 * @projectName moto
 * @description: 登陆服务
 * @date 2020/4/2116:16
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 加载用户数据 , 返回UserDetail 实例
     * @param userCode  用户登录userCode
     * @return  返回User实体类 做用户校验
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
        //根据用户名-查询用户信息
        SystemUser systemUser = userMapper.selectUserByUserCode(userCode);
        return systemUser;

    }
}
