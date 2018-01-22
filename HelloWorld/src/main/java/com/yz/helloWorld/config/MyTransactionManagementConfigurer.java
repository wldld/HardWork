package com.yz.streetsnapsline.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class MyTransactionManagementConfigurer implements TransactionManagementConfigurer {

    @Resource
    private Environment env;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return getTransactionManager();
    }

    /**
     * 数据源
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));

        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSourceTransactionManager getTransactionManager() {//获得数据转换管理器
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(getDataSource());
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionAwareDataSourceProxy getTransactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(getDataSource());
    }

    @Bean
    public DataSourceConnectionProvider getConnectionProvider() {
        return new DataSourceConnectionProvider(getDataSource());
    }

    /**
     * jooq config
     */
    @Bean
    public DefaultConfiguration getJooqConfig() {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setSQLDialect(SQLDialect.MYSQL);
        defaultConfiguration.setConnectionProvider(getConnectionProvider());
        return defaultConfiguration;
    }

    @Bean
    public DefaultDSLContext getJooqDsl() {
        return new DefaultDSLContext(getJooqConfig());
    }
}
