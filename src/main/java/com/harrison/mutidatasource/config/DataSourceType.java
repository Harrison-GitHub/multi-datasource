package com.harrison.mutidatasource.config;

/**
 * @Description: 设置数据源类型
 * @Author: HanYu
 * @Date: 2020/12/28
 **/
public class DataSourceType {
    
    private  static  final  ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();
    
    /**
     * 设置数据库连接类型
     * @param type 数据源类型 (枚举类型)
     */
    public  static  void setDataBaseType (DataBaseType type){
        
        if(type == null){
            throw  new NullPointerException();
        }
        TYPE.set(type);
    }
    
    /**
     * 获取数据源类型
     * @return DataBaseType (枚举类型)
     */
    public  static  DataBaseType getDataBaseType(){
        // 默认值是第一个
        DataBaseType baseType=TYPE.get() == null ? DataBaseType.PRIMARY : TYPE.get();
        return  baseType;
    }

    /**
     * 删除数据源类型
     */
    public  static  void clearDataBaseType(){
        TYPE.remove();
    }
    
}
