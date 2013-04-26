package com.zeng.linkedbindings;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        Service service = injector.getInstance(Service.class);
        service.test();
    }
}
