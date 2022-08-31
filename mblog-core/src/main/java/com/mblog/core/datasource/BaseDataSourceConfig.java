package com.mblog.core.datasource;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lauy
 */
//@Configuration
@EnableTransactionManagement
public class BaseDataSourceConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     * 针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
     *
     * 此处@Configuration使用了，就不能继承再次注解来重写覆盖
     * The bean 'mybatisPlusInterceptor', defined in class path resource
     * [com/mblog/core/config/BaseDataSourceConfig.class], could not be registered.
     * A bean with that name has already been defined in class path resource
     * [com/mblog/admin/config/DataSourceConfig.class] and overriding is disabled.
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

}
