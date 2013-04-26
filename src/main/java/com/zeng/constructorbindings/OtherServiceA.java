package com.zeng.constructorbindings;

public class OtherServiceA {

    public Service service;

    public OtherServiceA(Service service) {
        this.service = service;
    }

    public void test(){
        service.test();
    }

}
