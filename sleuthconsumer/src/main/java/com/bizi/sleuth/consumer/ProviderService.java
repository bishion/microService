package com.bizi.sleuth.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "sleuthprovider")
public interface ProviderService {
    @RequestMapping("/sayHi")
    String sayHi();
}
