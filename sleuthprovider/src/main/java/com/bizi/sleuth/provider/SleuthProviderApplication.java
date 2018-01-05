package com.bizi.sleuth.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SleuthProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthProviderApplication.class,args);
    }

    @RequestMapping("/health")
    public Status health(HttpServletRequest httpServletRequest){
        return new Status();
    }
    @RequestMapping("/sayHi")
    public String sayHi(HttpServletRequest httpServletRequest){
        return "HI";
    }
    class Status{
        private String status="UP";

        public String getStatus() {
            return status;
        }
    }
}
