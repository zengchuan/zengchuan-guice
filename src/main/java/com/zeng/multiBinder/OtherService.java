package com.zeng.multiBinder;


import javax.inject.Inject;
import java.util.Map;

public class OtherService {

    private String type;
    @Inject
    public Map<String, Service> serviceMap;


    public OtherService() {
    }

    public void test(){
        String s =  getType();
        serviceMap.get(s).test();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
