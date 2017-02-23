package com.bizi.ribbon;

import com.netflix.client.ClientFactory;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by guofangbi on 2017/1/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        return restTemplate.getForEntity("http://eurekaprovider/hello",String.class).getBody();
    }

    @RequestMapping("/ribbon")
    public String ribbon(){
        DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) ClientFactory.getNamedLoadBalancer("");
        lb.getServerList(false);
        return null;
    }
}
