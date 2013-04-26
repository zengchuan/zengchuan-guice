package com.zeng.throwingprovider;

import com.google.inject.AbstractModule;
import com.google.inject.throwingproviders.ThrowingProviderBinder;


public class Module extends AbstractModule {
    public void configure() {
        ThrowingProviderBinder.create(binder())
                .bind(GeneralProVider.class , Service.class)
                .to(AProvider.class);
        bind(Sample.class);
    }


}
