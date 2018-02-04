package com.bizi.sleuth.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthProviderApplication.class,args);
    }

    @Resource
    private ProviderService providerService;
    @RequestMapping("/health")
    public Status health(HttpServletRequest httpServletRequest){
        return new Status();
    }
    @RequestMapping("/sayHi")
    public String sayHi(HttpServletRequest httpServletRequest){
        new Thread(new Runnable() {
            @Override
            public void run() {
                providerService.sayHello();
            }
        }).start();
        return providerService.sayHello();
    } @RequestMapping("/sayHello")
    public String sayHello(){
        return new Status().toString();
    }
    class Status{
        private String status="UP";

        public String getStatus() {
            return status;
        }
    }
}
