package com.zeng.providerbindings;

import com.google.inject.AbstractModule;


public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).toProvider(AProvider.class);
    }


}
