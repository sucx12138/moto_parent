package com.soft.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2914:17
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}