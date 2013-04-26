package com.zeng.factoryprovider;

import com.google.inject.Inject;

public class FooLookupImpl implements FooLookup{
    @Inject
    private FooFactory factory;

    @Override
    public Foo lookup(String name){
        return this.factory.create(name);
    }
}