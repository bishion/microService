package com.bizi.consulclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guofangbi on 2016/12/27.
 */
@FeignClient("consulserver")
public interface HelloService {
    @RequestMapping("/sayHello")
    String sayHello(String name);
}
