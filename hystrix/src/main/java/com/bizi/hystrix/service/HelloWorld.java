package com.bizi.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guofangbi on 2017/6/6.
 */
public class HelloWorld extends HystrixCommand<String>{
    private final String name;
    public HelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("name"));
        this.name = name;
    }

    protected String run() throws Exception {
        return "Hello "+name+"!";
    }
}
