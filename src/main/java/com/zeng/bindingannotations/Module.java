package com.zeng.bindingannotations;

import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).annotatedWith(AnnoA.class).to(AService.class);
        bind(Service.class).annotatedWith(AnnoB.class).to(BService.class);
        bind(OtherServiceA.class);
        bind(OtherServiceB.class);
    }
}
