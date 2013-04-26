package com.zeng.aopparameter;

import com.google.inject.Inject;

public class OtherServiceA {

    public Service service;

    @Inject
    public OtherServiceA(Service service) {
        this.service = service;
    }

    @NotWorkOnTwo
    public void test(){
        service.test();
    }

}
