package com.zeng.aopparameter;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).to(AService.class);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(NotWorkOnTwo.class),
                new NotWorkInterceptor());
        bind(OtherServiceA.class);
    }
}
