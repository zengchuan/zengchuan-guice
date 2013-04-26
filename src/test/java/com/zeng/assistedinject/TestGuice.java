package com.zeng.assistedinject;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class TestGuice {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new FooModule());
        FooLookup f = injector.getInstance(FooLookup.class);
        Foo foo = f.lookup("aaa","bbb");

        System.out.println("Foo#getNum()    = "+foo.getNum());
        System.out.println("Foo#getFname()   = "+foo.getFname());
        System.out.println("Foo#getSname()   = "+foo.getSname());
        System.out.println("Foo#getColor()  = "+foo.getColor());
    }
}
