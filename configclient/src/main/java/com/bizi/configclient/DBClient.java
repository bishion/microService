package com.bizi.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guofangbi on 2017/6/30.
 */
@Service
public class DBClient {
    @Autowired
    public DBClient(DBConfiguration dBConfiguration){
        // do sth init db
        System.out.println(dBConfiguration.getIp());
    }
}
