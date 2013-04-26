package com.zeng.linkedbindings;

import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).to(AService.class);
    }
}
