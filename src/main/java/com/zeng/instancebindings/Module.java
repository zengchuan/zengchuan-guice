package com.zeng.instancebindings;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class Module extends AbstractModule {
    public void configure() {
        bind(Integer.class)
                .annotatedWith(Names.named("login timeout seconds"))
                .toInstance(10);
        bind(Service.class);
    }
}
