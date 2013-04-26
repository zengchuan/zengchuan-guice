package com.zeng.methodinterceptor;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new Module());
        OtherService otherService = injector.getInstance(OtherService.class);
        otherService.setType("A");
        try{
            otherService.test();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
