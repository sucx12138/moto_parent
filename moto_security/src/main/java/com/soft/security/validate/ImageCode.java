package com.soft.security.validate;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2913:48
 */
@Data
public class ImageCode {
    /**
     * 图片
     */
    private BufferedImage image;
    /**
     * 随机数
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }
    public ImageCode(BufferedImage image, String code, int  expireIn) {
        this.image = image;
        this.code = code;
        //当前时间  加上  设置过期的时间
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpires(){
        //如果 过期时间 在 当前日期 之前，则验证码过期
        return LocalDateTime.now().isAfter(expireTime);
    }
}
