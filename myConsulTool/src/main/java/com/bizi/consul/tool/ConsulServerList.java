package com.bizi.consul.tool;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.model.HealthService;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractServerList;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ConsulServerList extends AbstractServerList<ConsulServer> {
    private final MyConsulProperties myProperties = MyRibbonConsulAutoConfiguration.getInstance();
    private final ConsulClient client;
    private final ConsulDiscoveryProperties properties;
    private String serviceId;

    public ConsulServerList(ConsulClient client, ConsulDiscoveryProperties properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        this.serviceId = clientConfig.getClientName();
    }

    @Override
    public List<ConsulServer> getInitialListOfServers() {
        return getServers();
    }

    @Override
    public List<ConsulServer> getUpdatedListOfServers() {
        return getServers();
    }

    private List<ConsulServer> getServers() {
        if (this.client == null) {
            return Collections.emptyList();
        }
        String tag = getTag(); // null is ok
        Response<Map<String, List<String>>> catalogServicesResponse = client.getCatalogServices(QueryParams.DEFAULT);
        Map<String, List<String>> catalogServices = catalogServicesResponse.getValue();

        List<String> serviceIds = MyConsulServerUtil.getServiceId(myProperties,serviceId,catalogServices);
        List<ConsulServer> servers = new ArrayList<ConsulServer>();
        for (String serviceIdTemp:serviceIds){
            Response<List<HealthService>> response = this.client.getHealthServices(
                    serviceIdTemp, tag, true,
                    QueryParams.DEFAULT);
            if (response.getValue() == null || response.getValue().isEmpty()) {
                continue;
            }
            for (HealthService service : response.getValue()) {
                servers.add(new ConsulServer(service));
            }
        }

        return servers;
    }

    protected String getTag() {
        return this.properties.getQueryTagForService(this.serviceId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConsulServerList{");
        sb.append("serviceId='").append(serviceId).append('\'');
        sb.append(", tag=").append(getTag());
        sb.append('}');
        return sb.toString();
    }
}
