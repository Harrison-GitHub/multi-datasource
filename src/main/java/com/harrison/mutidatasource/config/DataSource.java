package com.harrison.mutidatasource.config;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    /**
     * 切换数据源名称
     * @return  PRIMARY , SECOND
     */
    DataBaseType value() default DataBaseType.PRIMARY;
}
