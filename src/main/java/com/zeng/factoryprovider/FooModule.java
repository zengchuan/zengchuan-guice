package com.zeng.factoryprovider;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;


public class FooModule extends AbstractModule {
    public void configure() {
        bind(int.class).toInstance(124);
        bind(String.class).toInstance("Red");
        bind(FooLookup.class).to(FooLookupImpl.class);
        install(new FactoryModuleBuilder()
                .implement(Foo.class, FooImpl.class)
                .build(FooFactory.class));
    }


}
