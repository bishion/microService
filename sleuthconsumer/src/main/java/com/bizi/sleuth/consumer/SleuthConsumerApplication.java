package com.bizi.sleuth.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SleuthConsumerApplication {
    @Resource
    private ProviderService providerService;

    @RequestMapping("/sayHi")
    public String sayHi(){
        return providerService.sayHi();
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthConsumerApplication.class,args);
    }
}
