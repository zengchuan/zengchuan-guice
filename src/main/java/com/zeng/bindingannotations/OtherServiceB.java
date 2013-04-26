package com.zeng.bindingannotations;

import com.google.inject.Inject;

public class OtherServiceB {
    @Inject
    @AnnoB
    public Service service;

    public void test(){
        service.test();
    }

}
