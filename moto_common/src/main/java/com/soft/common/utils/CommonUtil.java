package com.soft.common.utils;

import java.util.UUID;

/**
 * @author sucx
 * @title: CommonUtil
 * @projectName springboot_demo
 * @description: 公用工具类
 * @date 2020/1/2117:05
 */
public final class CommonUtil {
    private CommonUtil(){}
    /**
     * 生成UUID
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
