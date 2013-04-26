package com.zeng.constructorbindings;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        OtherServiceA otherServiceA = injector.getInstance(OtherServiceA.class);
        otherServiceA.test();
    }
}
