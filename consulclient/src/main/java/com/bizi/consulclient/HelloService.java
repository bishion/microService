package com.bizi.consulclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by guofangbi on 2016/12/27.
 */
@FeignClient("consulserver")
public interface HelloService {
    @RequestMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/dataTrans")
    UserDTO dataTrans(@RequestBody UserDTO userDTO);
    @RequestMapping(value = "/batchDataTrans",method = RequestMethod.POST)
    UserDTO batchDataTrans(@RequestBody List<UserDTO> userDTO);
}
