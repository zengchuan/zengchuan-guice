package com.zeng.instancebindings;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Service {

    @Inject
    @Named("login timeout seconds")
    public int timeout;

    public void test(){
        System.out.println("timeout is:" + timeout);
    }

}
