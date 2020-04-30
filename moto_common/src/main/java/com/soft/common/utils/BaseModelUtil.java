package com.soft.common.utils;


import com.soft.common.model.BaseModel;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author sucx
 * @title: BaseModelUtil
 * @projectName springboot_demo
 * @description: 模型数据封装类
 * @date 2020/1/2210:22
 */
@Slf4j
public final class BaseModelUtil {

    /**
     * 创建基础数据
     */
    public static void setCreateBaseInfo(Optional<Object> model){
        model.ifPresent((data) -> {
           if (data instanceof BaseModel){
               BaseModel baseMode = (BaseModel)data;
               baseMode.setId(CommonUtil.getUuid());
               baseMode.setCreateTime(DateUtil.getCurrentDate());
               baseMode.setCreateUser(null);
               baseMode.setCreateIp(NetworkUtil.getRemoteIp());
               //默认状态
               if (null == baseMode.getStatus()){
                   baseMode.setStatus(Constants.MODEL_STATUS_NORMAL);
               }
           }
        });
    }

    /**
     * 更新基础数据
     */
    public static void setUpdateBaseInfo(Optional<Object> model){
        model.ifPresent((data) -> {
            if (data instanceof BaseModel){
                BaseModel baseModel = (BaseModel) data;
                baseModel.setUpdateTime(DateUtil.getCurrentDate());
                baseModel.setUpdateUser(null);
                baseModel.setUpdateIp(NetworkUtil.getRemoteIp());
                //默认状态
                if (null == baseModel.getStatus()){
                    baseModel.setStatus(Constants.MODEL_STATUS_NORMAL);
                }
            }
        });

    }


}
