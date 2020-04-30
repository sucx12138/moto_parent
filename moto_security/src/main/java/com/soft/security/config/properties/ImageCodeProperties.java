package com.soft.security.config.properties;

import lombok.Data;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2914:00
 */
@Data
public class ImageCodeProperties {
    /**
     * 验证码宽度
     */
    private int width = 67;
    /**
     * 高度
     */
    private int height = 23;
    /**
     * 长度（几个数字）
     */
    private int length = 4;
    /**
     * 过期时间
     */
    private int expireIn = 60;

    /**
     * 需要图形验证码的 url
     */
    private String url;
}
