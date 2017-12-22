package com.bizi.consulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by guofangbi on 2016/12/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class ConsulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApplication.class, args);
    }

    @RequestMapping("/sayHello")
    public String hello(String name) {
        return "Hello," + name;
    }

    @RequestMapping("/ok/health")
    public Health health() {
        System.err.println("check health");
        return Health.up().build();
    }

    @RequestMapping("/dataTrans")
    public UserDTO dataTrans(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @RequestMapping(value = "/batchDataTrans", method = RequestMethod.POST)
    public UserDTO batchDataTrans(@RequestBody List<UserDTO> userDTOS) {
        return userDTOS.get(0);
    }
}
