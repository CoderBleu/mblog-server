package com.mblog.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mblog.core.datasource.BaseDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lauy
 */
@MapperScan(basePackages = {"com.mblog.business.**.dao"})
@Configuration
public class DataSourceConfig extends BaseDataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


}
