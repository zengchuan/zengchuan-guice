package com.zeng.bindingannotationsnamed;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuiceB {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        OtherServiceB otherServiceB = injector.getInstance(OtherServiceB.class);
        otherServiceB.test();
    }
}
