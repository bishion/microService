package com.bizi.consulclient;

import com.ecwid.consul.v1.ConsulClient;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulRibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor guofangbi
 * @date 17-11-20 下午8:53
 */
//@Configuration
//@AutoConfigureAfter(ConsulRibbonClientConfiguration.class)
public class ConsulConfiguration {
    @Autowired
    private ConsulClient client;
    @Bean
    public ServerList<?> ribbonServerList(IClientConfig config, ConsulDiscoveryProperties properties) {
        ConsulServerList serverList = new ConsulServerList(client, properties);
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
}
