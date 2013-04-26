package com.zeng.bindingannotationsnamed;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).annotatedWith(Names.named("nameA")).to(AService.class);
        bind(Service.class).annotatedWith(Names.named("nameB")).to(BService.class);

        bind(OtherServiceA.class);
        bind(OtherServiceB.class);
    }
}
