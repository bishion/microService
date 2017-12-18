package com.bizi.demo;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

public class MyConfigInfoEndport extends AbstractEndpoint<Map<String,Object>> implements ApplicationContextAware {
    private ApplicationContext context;

    public MyConfigInfoEndport() {
        super("configinfo");
    }

    public Map<String, Object> invoke() {
        System.out.println("sdfsdf");
        return null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
