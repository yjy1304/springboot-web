package com.self;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.self.shiro.UserRealm;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by 健民 on 2016/2/2.
 */
public class WebConfig extends WebMvcConfigurerAdapter{
    @Bean
    public DispatcherServlet dispatcherServlet(){
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setDispatchOptionsRequest(true);
        return servlet;
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/sophia/*");

        return registration;
    }

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//
//        Map<String, MediaType> types = new HashMap<>();
//        types.put("json", APPLICATION_JSON);
//        types.put("xml", APPLICATION_XML);
//
//        configurer
//                .defaultContentType(APPLICATION_JSON)
//                .mediaTypes(types);
//
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(jackson());
        converters.add(jaxb());

        super.configureMessageConverters(converters);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson() {

        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.getObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return converter;
    }

    @Bean
    public Jaxb2RootElementHttpMessageConverter jaxb() {

        final Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();

        return converter;
    }

    /*@Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setLoginUrl("*//**");
        shiroFilter.setSecurityManager(securityManager());

        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("anon", new FormAuthenticationFilter());
        filters.put("authc", new FormAuthenticationFilter());
        shiroFilter.setFilters(filters);

        return shiroFilter;
    }

    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(sophiaRealm());

        return securityManager;
    }*/

    @Bean(name = "sophiaRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm sophiaRealm() {
        return new UserRealm();
    }

//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
}
