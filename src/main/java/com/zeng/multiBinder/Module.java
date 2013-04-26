package com.zeng.multiBinder;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;


import java.lang.reflect.Field;

public class Module extends AbstractModule {
    public void configure() {

        bind(OtherService.class);
        MapBinder<String, Service> mapBinder = MapBinder.newMapBinder(binder(), String.class, Service.class);
        mapBinder.addBinding("B").to(BService.class);
        mapBinder.addBinding("A").to(AService.class);
    }
}
