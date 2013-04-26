package com.zeng.methodinterceptor;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

public class Module extends AbstractModule {
    public void configure() {

        bind(OtherService.class);
        bindInterceptor(any(), annotatedWith(ChangeType.class), new ChangeTypeInterceptor());

    }
}
