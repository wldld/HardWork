package com.yz.streetsnapsline.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration//Configuration是配置的意思
@EnableWebMvc //允许webMvc形式？
@ComponentScan(basePackages = "com.yz.HelloWorld", useDefaultFilters = false, includeFilters = {//设置扫描器扫描根目录，不使用默认的过滤器，自定义过滤器
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class}),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestControllerAdvice.class}),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Component.class}),
})
@EnableScheduling//允许定时任务
@Import({MyWebMvcConfigurationSupport.class, MyTransactionManagementConfigurer.class})//引用其他的配置文件
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {//自定义配置适配器，继承WebMvcConfigurerAdapter

    /**
     *
     * @return
     */

    @Bean
    public FieldRetrievingFactoryBean getDisableCircularReferenceDetect() {//  域检索工厂，获得失效的循环引用侦测
        FieldRetrievingFactoryBean fieldRetrievingFactoryBean = new FieldRetrievingFactoryBean();
        fieldRetrievingFactoryBean.setStaticField("com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect");
        return fieldRetrievingFactoryBean;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        return new LocalValidatorFactoryBean();
    }//获得验证器

    @Override
    public void addCorsMappings(CorsRegistry registry) {//cors卫星定位服务？？？？？
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
    }

}
