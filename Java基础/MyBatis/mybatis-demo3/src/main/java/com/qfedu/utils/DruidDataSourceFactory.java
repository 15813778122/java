package com.qfedu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDataSourceFactory extends PooledDataSourceFactory {
    // 先要继承PooledDataSourceFactory，通过无参构造器使父类的dataSource重置为DruidDataSource，通过父类的getDataSource方法把dataSource return出去
    public DruidDataSourceFactory() {
        //no instance
        this.dataSource = new DruidDataSource();
    }
}
