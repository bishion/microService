package com.bizi.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.name}")
    String name;
    @RequestMapping("/hello")
    public String hello(){
        return "SUCCESS";
    }
}
