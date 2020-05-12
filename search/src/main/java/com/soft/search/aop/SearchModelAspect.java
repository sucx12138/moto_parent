package com.soft.search.aop;


import com.soft.common.aop.CommonModelAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sucx
 * @title: CommonModelAspect
 * @projectName springboot_demo
 * @description: 数据模型切面
 * @date 2020/1/2211:02
 */
@Component
@Aspect
public class SearchModelAspect {
    @Autowired
    private CommonModelAspect commonModelAspect;


    @Pointcut("execution(public * com.soft.*.service.impl..save*(..))")
    public void saveAspect(){ }
    @Pointcut("execution(public * com.soft.*.service.impl..insert*(..))")
    public void insertAspect(){ }
    @Pointcut("execution(public * com.soft.*.service.impl..add*(..))")
    public void addAspect(){ }
    @Pointcut("execution(public * com.soft.*.service.impl..update*(..))")
    public void updateAspect(){ }
    @Pointcut("execution(public * com.soft.*.service.impl..edit*(..))")
    public void editAspect(){ }

    @Before("saveAspect()")
    public void saveBefore(JoinPoint joinPoint){
        commonModelAspect.saveBefore(joinPoint);
    }
    @Before("insertAspect()")
    public void insertBefore(JoinPoint joinPoint){
        commonModelAspect.insertBefore(joinPoint);
    }
    @Before("addAspect()")
    public void addBefore(JoinPoint joinPoint){
        commonModelAspect.addBefore(joinPoint);
    }

    @Before("updateAspect()")
    public void updateBefore(JoinPoint joinPoint){
        commonModelAspect.updateBefore(joinPoint);
    }
    @Before("editAspect()()")
    public void editBefore(JoinPoint joinPoint){
        commonModelAspect.editBefore(joinPoint);
    }

}
