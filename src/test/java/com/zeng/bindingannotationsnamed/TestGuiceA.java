package com.zeng.bindingannotationsnamed;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuiceA {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        OtherServiceA otherServiceA = injector.getInstance(OtherServiceA.class);
        otherServiceA.test();
    }
}
