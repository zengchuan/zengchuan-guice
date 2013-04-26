package com.zeng.bindingannotationsnamed;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class OtherServiceB {
    @Inject
    @Named("nameB")
    public Service service;

    public void test(){
        service.test();
    }

}
