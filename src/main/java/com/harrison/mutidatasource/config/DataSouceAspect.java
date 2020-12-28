package com.harrison.mutidatasource.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: AOP动态设置数据源--切面类
 * @Author: HanYu
 * @Date: 2020/12/28
 **/
@Aspect
@Component
public class DataSouceAspect {

    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.harrison.mutidatasource.config.DataSource)")
    public void dataSourcePointCut() {}


    /**
     * 获取连接点@DataSource注解的值(所要使用的数据源)
     * @param point 连接点
     * @return Object
     * @throws Throwable
     */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取方法签名 
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 获取方法上面的数据源注解
        DataSource ds = method.getAnnotation(DataSource.class);
        // 通过 DataSource 中的值来判断当前方法应用哪个数据源, 设置相应的数据源
        DataSourceType.setDataBaseType(ds.value());
        try {
            return point.proceed();
        } finally {
            // 清除设置的数据源
            DataSourceType.clearDataBaseType();
        }
    }

    

}
