package com.bizi.hystrix.service;

import java.util.Random;

/**
 * Created by guofangbi on 2017/6/27.
 */
public class RandomUtil {

    public static boolean randomFlag() {
        return new Random().nextInt(2) == 0;
    }
}
