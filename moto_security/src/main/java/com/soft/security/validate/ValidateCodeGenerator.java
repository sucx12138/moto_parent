package com.soft.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2913:49
 */
public interface ValidateCodeGenerator {
    /**
     * 创建验证码
     * @param request
     * @return
     */
    ImageCode  createCode(ServletWebRequest request);
}
