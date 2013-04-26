package com.zeng.methodinterceptor;


import javax.inject.Inject;
import java.util.Map;

public class OtherService {

    public String type;

    public Service service;

    public OtherService() {
    }

    @ChangeType
    public void test(){
        service.test();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
