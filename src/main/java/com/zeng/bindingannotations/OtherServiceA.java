package com.zeng.bindingannotations;

import com.google.inject.Inject;

public class OtherServiceA {

    public Service service;

    @Inject
    public OtherServiceA(@AnnoA Service service) {
        this.service = service;
    }

    public void test(){
        service.test();
    }

}
