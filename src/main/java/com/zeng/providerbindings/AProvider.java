package com.zeng.providerbindings;

import com.google.inject.Provider;

public class AProvider implements Provider<Service> {

    public Service get(){
        Service service = new Service("test provide");
        return service;
    }
}
