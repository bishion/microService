package com.bizi.sleuth.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SleuthConsumerApplication {

    @Resource
    private ProviderService providerService;

    @Resource
    private Executor executor;
    @RequestMapping("/sayHi")
    public String sayHi(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                providerService.sayHi();
            }
        });
        return "S" +
                "" +
                "UCCESS";
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
