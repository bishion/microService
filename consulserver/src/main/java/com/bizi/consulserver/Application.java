package com.bizi.consulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guofangbi on 2016/12/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @RequestMapping("/sayHello")
    public String hello(String name){
        return "Hello,"+name;
    }
    @RequestMapping("/health")
    public Health health(){
        System.err.println("Hello");
        return Health.up().build();
    }
}
