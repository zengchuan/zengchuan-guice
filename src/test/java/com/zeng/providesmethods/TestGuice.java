package com.zeng.providesmethods;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        Service service = injector.getInstance(Service.class);
        System.out.println(service.getName());
    }
}
