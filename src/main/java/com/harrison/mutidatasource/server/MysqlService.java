package com.harrison.mutidatasource.server;

import com.harrison.mutidatasource.config.DataBaseType;
import com.harrison.mutidatasource.config.DataSource;
import com.harrison.mutidatasource.config.DataSourceType;
import com.harrison.mutidatasource.dao.MysqlDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: HanYu
 * @Date: 2020/11/16
 **/
@Service
public class MysqlService {
    
    @Resource
    private MysqlDao mysqlDao;
    
    @DataSource(DataBaseType.PRIMARY)
    public  void  local(){
        List<Map> local = mysqlDao.local();

        for (Map map:local) {
            System.out.println(map.toString());
        }
        
    }

    @DataSource(DataBaseType.SECOND)
    public  void  remote(){
        List<Map> local = mysqlDao.remote();

        for (Map map:local) {
            System.out.println(map.toString());
        }

    }
    
    
    
    
    
}
