package com.bizi.sleuth.consumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TemplateController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private RestTemplate restTemplate2;
    @Resource
    private RestTemplate restTemplate3;
    @RequestMapping("/testNewTemplate")
    public String testNewTemplate(){
        return new RestTemplate().getForObject("http://localhost:9413/sayHello",String.class);
    }
    @RequestMapping("/testTemplateBean")
    public String testTemplateBean(){
        return restTemplate.getForObject("http://localhost:9413/sayHello",String.class);
    }
    @RequestMapping("/testTemplateBean2")
    public String testTemplateBean2(){
        return restTemplate2.getForObject("http://localhost:9413/sayHello",String.class);
    }
    @RequestMapping("/testTemplateBean3")
    public String testTemplateBean3(){
        return restTemplate3.getForObject("http://localhost:9413/sayHello",String.class);
    }
}
