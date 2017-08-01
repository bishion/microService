package com.bizi.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guofangbi on 2016/12/26.
 */
@RefreshScope
@SpringBootApplication
@RestController

public class ConfigClientApplication {
    @Value("${server.name}")
    String luckyWord;

    @RequestMapping("/printValue")
    public String printValue() {
        System.out.println(luckyWord);
        return luckyWord;
    }

    public static void main(String[] args) {
//        System.setProperty("DEPLOY_ENV", "dev");
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
