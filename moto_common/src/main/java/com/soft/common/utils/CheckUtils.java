package com.soft.common.utils;

import com.soft.common.exception.BadRequestException;
import org.springframework.util.StringUtils;

/**
 * 检查工具
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/4/2911:00
 */
public final class CheckUtils {

    private CheckUtils(){}
    /**
     * 检查主键不为空
     * @param id
     */
    public static void checkPrimaryKeyNotNull(String id){
        if (StringUtils.isEmpty(id)){
            throw new BadRequestException(Constants.CONTROLLER_MESSAGE_ID_IS_NULL);
        }
    }
}
