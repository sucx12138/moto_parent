package com.soft.common.aop;


import com.soft.common.utils.BaseModelUtil;
import org.aspectj.lang.JoinPoint;

import java.util.Optional;

/**
 * @author sucx
 * @title: CommonModelAspect
 * @projectName springboot_demo
 * @description: 数据模型切面
 * @date 2020/1/2211:02
 */
public class CommonModelAspect {

    public void saveBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }
    public void insertBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }
    public void addBefore(JoinPoint joinPoint){
        setCreateBaseInfo(joinPoint);
    }

    public void updateBefore(JoinPoint joinPoint){
        setUpdateBaseInfo(joinPoint);
    }
    public void editBefore(JoinPoint joinPoint){
        setUpdateBaseInfo(joinPoint);
    }

    /**
     * 更新数据模型基础字段添加
     * @param joinPoint
     */
    private void setUpdateBaseInfo(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] objs = joinPoint.getArgs();
        if (null == objs){
            return;
        }
        //封装基础数据
        for (Object obj : objs) {
            BaseModelUtil.setUpdateBaseInfo(Optional.ofNullable(obj));
        }
    }

    /**
     * 新增数据模型基础字段添加
     * @param joinPoint
     */
    private void setCreateBaseInfo(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] objs = joinPoint.getArgs();
        if (null == objs){
            return;
        }
        //封装基础数据
        for (Object obj : objs) {
            BaseModelUtil.setCreateBaseInfo(Optional.ofNullable(obj));
        }
    }


}
