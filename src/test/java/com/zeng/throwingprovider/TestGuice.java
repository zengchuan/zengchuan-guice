package com.zeng.throwingprovider;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        try{
            Injector injector = Guice.createInjector(new Module());
            Sample sample = injector.getInstance(Sample.class);
            sample.exec();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
