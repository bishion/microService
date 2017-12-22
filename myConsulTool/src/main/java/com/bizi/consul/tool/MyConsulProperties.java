package com.bizi.consul.tool;

import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor guofangbi
 * @date 17-11-22 上午11:29
 */
public class MyConsulProperties {
    private Map<String, String> projectIdMap = new HashMap();
    private String env;
    private boolean isPublic;
    private String projectId;

    public MyConsulProperties(){
        this.env = System.getenv("DEPLOY_ENV");
        projectId = System.getenv("PROJECT_ID");
        if ("test".equals(this.env)) {
            this.isPublic = projectId == null;
        }
    }
    public Map<String, String> getProjectIdMap() {
        return projectIdMap;
    }

    public void setProjectIdMap(String crossProjectMapStr) {
        if (StringUtils.isBlank(crossProjectMapStr)) {
            return;
        }
        for (String keyValue : Splitter.on(";").trimResults().omitEmptyStrings().split(crossProjectMapStr)) {
            String[] keyValueArray = keyValue.split(":");
            if (keyValueArray.length > 1) {
                projectIdMap.put(keyValueArray[0], keyValueArray[1]);
            }
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public String getEnv() {
        return env;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
