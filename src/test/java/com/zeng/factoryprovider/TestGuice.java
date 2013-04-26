package com.zeng.factoryprovider;


import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new FooModule());
        FooLookup f = injector.getInstance(FooLookup.class);
        Foo foo = f.lookup("aaa");

        System.out.println("Foo#getNum()    = "+foo.getNum());
        System.out.println("Foo#getName()   = "+foo.getName());
        System.out.println("Foo#getColor()  = "+foo.getColor());
    }
}
