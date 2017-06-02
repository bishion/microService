package com.bizi.velocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guofangbi on 2017/2/18.
 */

@SpringBootApplication
@Controller
public class VelocityApplication {
    public static void main(String[] args) {
        SpringApplication.run(VelocityApplication.class, args);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "SUCCESS";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
