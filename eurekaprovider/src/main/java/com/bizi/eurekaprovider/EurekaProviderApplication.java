package com.bizi.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guofangbi on 2016/12/30.
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class EurekaProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/add")
    public String add() {
        ServiceInstance instance = client.getLocalServiceInstance();
        return instance.getHost() + ";" + instance.getServiceId();
    }

    @RequestMapping("/hello")
    public String hello(String username) {
        return "Hello," + username;
    }
    @RequestMapping("/params")
    public String getRepFromParams(UserDTO userDTO,StudentDTO studentDTO){
        return userDTO.getUsername()+" "+studentDTO.getStudentNo();
    }
}
