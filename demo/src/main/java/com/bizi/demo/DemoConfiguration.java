package com.bizi.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class DemoConfiguration {
    @Bean
    public MyConfigInfoEndport myConfigInfoEndport() {
        return new MyConfigInfoEndport();
    }
}
