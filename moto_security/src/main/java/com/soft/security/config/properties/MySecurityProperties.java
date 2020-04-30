package com.soft.security.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sucx
 * @projectName moto
 * @description: 安全管理配置
 * @date 2020/4/2115:37
 */
@Component
@ConfigurationProperties(prefix = "spring.security")
@Data
public class MySecurityProperties {
    /**
     * 验证码
     */
    private ValidateCodeProperties  code = new ValidateCodeProperties();

    /**
     * 浏览器 属性类
     */
    private BrowserProperties browser = new BrowserProperties();

}
