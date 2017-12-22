package com.bizi.consul.tool;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @autor guofangbi
 * @date 17-11-23 下午9:29
 */
public final class MyConsulServerUtil {

    public static List<String> getServiceId(MyConsulProperties myProperties, String serviceId, Map<String, List<String>> catalogServices) {
        List<String> serviceIds = new ArrayList<String>();
        if ("test".equalsIgnoreCase(myProperties.getEnv())) {
            boolean isSpecial = myProperties.getProjectIdMap().containsKey(serviceId);
            List<String> sameProjectIdList = new ArrayList<String>();
            List<String> publicProjectIdList = new ArrayList<String>();

            for (Map.Entry<String, List<String>> entry : catalogServices.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) {
                    continue;
                }

                List<String> serviceTags = entry.getValue();
                for (String serviceTag : serviceTags) {
                    if (!serviceTag.endsWith("_" + serviceId + "-/")) {
                        continue;
                    }
                    // 如果是特殊配置，先走特殊配置
                    if (isSpecial && serviceTag.startsWith(myProperties.getProjectIdMap().get(serviceId) + "-")) {
                        serviceIds.add(entry.getKey());
                        break;
                    }
                    if (serviceTag.startsWith(myProperties.getProjectId() + "-")) {
                        sameProjectIdList.add(entry.getKey());
                        break;
                    }
                    if (!Character.isDigit(serviceTag.charAt(1))) {
                        publicProjectIdList.add(entry.getKey());
                        break;
                    }
                }
            }
            // 公共环境
            if (myProperties.isPublic()) {
                serviceIds = publicProjectIdList;
            } else if (CollectionUtils.isEmpty(serviceIds)) {
                serviceIds = CollectionUtils.isEmpty(sameProjectIdList) ? publicProjectIdList : sameProjectIdList;
            }

        } else {
            for (Map.Entry<String, List<String>> entry : catalogServices.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) {
                    continue;
                }

                List<String> serviceTags = entry.getValue();
                for (String serviceTag : serviceTags) {
                    if (serviceTag.endsWith("_" + serviceId + "-/")) {
                        serviceIds.add(entry.getKey());
                        break;
                    }

                }
            }
        }
        return serviceIds;
    }
}
