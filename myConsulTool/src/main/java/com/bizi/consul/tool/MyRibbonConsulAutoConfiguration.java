package com.bizi.consul.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConditionalOnConsulEnabled
@ConditionalOnBean(SpringClientFactory.class)
@AutoConfigureAfter(RibbonAutoConfiguration.class)
@ConditionalOnExpression("${spring.cloud.consul.ribbon.enabled}==false")
@RibbonClients(defaultConfiguration = ConsulRibbonClientConfiguration.class)
public class MyRibbonConsulAutoConfiguration {

    private static MyConsulProperties properties = new MyConsulProperties();
    @Value("${my.config.consul.projectIdMap:}")
    private String projectIdMap;

    @Bean
    public MyConsulProperties reInitMyConfig(){
        properties.setProjectIdMap(projectIdMap);

        return properties;
    }

    public static MyConsulProperties getInstance(){
        return properties;
    }
}
