package com.soft.security.config.properties;

import lombok.Data;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2914:00
 */
@Data
public class ValidateCodeProperties {
    /**
     * 图形验证码 配置属性
     */
    private ImageCodeProperties image = new ImageCodeProperties();
}
