package com.bizi.sleuth.provider;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "sleuthconsumer")
public interface ProviderService {
    @RequestMapping("/sayHello")
    String sayHello();
}
