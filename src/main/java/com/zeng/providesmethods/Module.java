package com.zeng.providesmethods;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class Module extends AbstractModule {
    public void configure() {
    }

    @Provides
    Service getNewServcie(){
        Service service = new Service("test");
        return service;
    }
}
