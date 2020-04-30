package com.soft.security.config.security;

import com.soft.security.config.properties.MySecurityProperties;
import com.soft.security.validate.ImageCodeGenerator;
import com.soft.security.validate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2913:55
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private MySecurityProperties securityProperties;

    /**
     *
     * 在触发 ValidateCodeGenerator 之前会检测有没有imageCodeGenerator这个bean。
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }
}
