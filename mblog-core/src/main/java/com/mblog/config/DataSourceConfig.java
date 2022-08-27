package com.mblog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.mblog.business")
@Configuration
public class DataSourceConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     * 针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
     */
    //@Bean
    //public MybatisPlusInterceptor mybatisPlusInterceptor() {
    //    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    //    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    //    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
    //    return interceptor;
    //}
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
