package com.bizi.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guofangbi on 2017/6/27.
 */
@Service
public class HystrixService {
    @RequestMapping("/testFallback.json")
    @HystrixCommand(fallbackMethod = "fallback")
    public String testFallback() {
        if (RandomUtil.randomFlag()) {
            return "not fallback";
        } else {
            throw new RuntimeException();
        }
    }
    public String fallback() {
        return "fallback in service";
    }
}
