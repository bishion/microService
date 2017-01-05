package com.bizi.consulclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by guofangbi on 2016/12/27.
 */
@FeignClient(value = "10081-zis_fusion_za-ding-16195-1482408135-1",url = "http://10081-zis_fusion_za-ding-16195-1482408135-1:8080")
public interface HelloService {
    @RequestMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/dataTrans")
    UserDTO dataTrans(@RequestBody UserDTO userDTO);
}
