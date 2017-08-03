package com.bizi.eurekaclient;

import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guofangbi on 2017/7/4.
 */
@FeignClient("eurekaprovider")
public interface DemoService {
    @RequestMapping(value = "/params",method = RequestMethod.POST)
    String getResult(@Param("userDTO") UserDTO userDTO, @Param("userDTO") StudentDTO studentDTO);
}
