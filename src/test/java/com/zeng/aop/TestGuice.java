package com.zeng.aop;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        OtherServiceA otherServiceA = injector.getInstance(OtherServiceA.class);
        try{
            otherServiceA.test();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
