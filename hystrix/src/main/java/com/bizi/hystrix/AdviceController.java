package com.bizi.hystrix;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by guofangbi on 2017/6/6.
 */
@ControllerAdvice
public class AdviceController {
    @ExceptionHandler
    public String handleException(Exception e){
        return e.toString();
    }
}
