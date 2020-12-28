package com.harrison.mutidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: HanYu
 * @Date: 2020/12/28
 **/
@Configuration
@MapperScan(basePackages = "com.harrison.mutidatasource.dao")
public class MybatisConfig {

    @Autowired
    private Environment environment;



    @Bean
    @Primary
    public  DynamicDataSource dynamicDataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                                @Qualifier("secondDataSource")DataSource secondDataSource){
        
        Map<Object,Object> targetDataSource =new HashMap<>();
        targetDataSource.put(DataBaseType.PRIMARY,primaryDataSource);
        targetDataSource.put(DataBaseType.SECOND,secondDataSource);
        
        DynamicDataSource dynamicDataSource=new DynamicDataSource(primaryDataSource,targetDataSource);
        
        return  dynamicDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置动态数据源
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        // 设置别名的包
        sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.type-aliases-package"));
        // 设置mapper文件存放的路径
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));
        return sqlSessionFactoryBean.getObject();
    }





}
