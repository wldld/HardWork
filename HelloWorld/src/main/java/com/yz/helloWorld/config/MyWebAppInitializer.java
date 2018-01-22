package com.yz.streetsnapsline.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(MyWebMvcConfigurerAdapter.class);

        //Log4jConfigListener
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);

        //spring dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dynamic.addMapping("/");

        //添加编码拦截器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration encodingFilterRegistration = servletContext.addFilter("encodingFilter", characterEncodingFilter);
        encodingFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");

    }
}
