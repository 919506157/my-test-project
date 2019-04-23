package com.zhang.bean;

import java.util.Map;

public class ServiceData {
    public String serviceType;
    public Map<String, String> data;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
