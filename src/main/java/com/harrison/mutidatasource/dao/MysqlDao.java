package com.harrison.mutidatasource.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: HanYu
 * @Date: 2020/11/16
 **/
@Mapper
public interface MysqlDao {
    
    
    List<Map> local();
    
    List<Map> remote();
    
    
    
}
