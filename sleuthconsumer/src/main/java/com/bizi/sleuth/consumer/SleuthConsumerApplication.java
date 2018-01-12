package com.bizi.sleuth.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello";
    }
    @RequestMapping("/health")
    public Status health(HttpServletRequest httpServletRequest){
        return new Status();
    }
    class Status{
        private String status="UP";

        public String getStatus() {
            return status;
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(SleuthConsumerApplication.class,args);
    }
}
