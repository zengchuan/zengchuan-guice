package com.zeng.constructorbindings;

import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
    public void configure() {
        bind(Service.class).to(AService.class);
        try {
            bind(OtherServiceA.class).toConstructor(OtherServiceA.class.getConstructor(Service.class)) ;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
