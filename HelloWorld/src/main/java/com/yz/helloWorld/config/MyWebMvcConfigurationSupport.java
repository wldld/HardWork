package com.yz.streetsnapsline.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yz.streetsnapsline.api.CustomRequestMappingHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

@Configuration//配置文件
public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {//请求映射处理
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

    @Bean
    public FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {//获得fastjson转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        ArrayList<MediaType> mediaTypes = new ArrayList<MediaType>();//媒体类型
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//加入了JSON UTF-8
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);//设置支持的媒体类型
        fastJsonHttpMessageConverter.setFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect);
        //写入map空值，写入用字符串为Empty，失效循环引用侦测
        return fastJsonHttpMessageConverter;
    }

    /**
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {//继承了消息转换器
        converters.add(getFastJsonHttpMessageConverter());//加入了fastjson消息转换器
    }
}