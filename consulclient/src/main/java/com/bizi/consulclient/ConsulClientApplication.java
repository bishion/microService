package com.bizi.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guofangbi on 2016/12/27.
 */
@RestController
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }

    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }

    @RequestMapping("/dataTrans")
    public UserDTO dataTrans() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(123);
        userDTO.setUsername("guofangbi");
        userDTO.setBirthday(new Date());
        return helloService.dataTrans(userDTO);
    }

    @RequestMapping("/batchDataTrans")
    public UserDTO batchDataTrans() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(123);
        userDTO.setUsername("guofangbi");
        userDTO.setBirthday(new Date());
        List<UserDTO> userDTOList = new ArrayList<UserDTO>(1);
        userDTOList.add(userDTO);
        return helloService.batchDataTrans(userDTOList);
    }
}
