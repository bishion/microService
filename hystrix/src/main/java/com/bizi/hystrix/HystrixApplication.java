package com.bizi.hystrix;

import com.bizi.hystrix.service.RandomUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by guofangbi on 2017/6/1.
 */
@SpringBootApplication
@EnableHystrix
@RestController
@EnableEurekaClient
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @RequestMapping("/testFallback.json")
    @HystrixCommand(fallbackMethod = "fallback")
    public String testFallback() {
        if (RandomUtil.randomFlag()) {
            return "not fallback";
        } else {
            throw new RuntimeException();
        }
    }


    @RequestMapping("/testTimeOut.json")
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String testTimeOut() {
        try {
            if (RandomUtil.randomFlag()) {

                Thread.sleep(4000l);
            } else {
                Thread.sleep(6000l);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "not fallback";
    }

    public String fallback() {
        return "fallback";
    }
}
