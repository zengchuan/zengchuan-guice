package com.zeng.bindingannotationsnamed;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class OtherServiceA {

    public Service service;

    @Inject
    public OtherServiceA(@Named("nameA") Service service) {
        this.service = service;
    }

    public void test(){
        service.test();
    }

}
