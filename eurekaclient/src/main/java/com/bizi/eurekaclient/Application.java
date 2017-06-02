package com.bizi.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guofangbi on 2017/1/4.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/sayHello")
    public String sayHello(String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "username");
        List<String> lit = discoveryClient.getServices();
        List<ServiceInstance> serviceList = discoveryClient.getInstances("eurekaprovider");
        if (serviceList.size() > 0) {
            String uri = serviceList.get(0).getUri().toString() + "/hello";
            return (new RestTemplate()).getForObject(uri, String.class, map);
        }
        return null;
    }
}
