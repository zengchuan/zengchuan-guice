package com.zeng.assistedinject;

import com.google.inject.Inject;

public class FooLookupImpl implements FooLookup {
    @Inject
    private FooFactory factory;

    @Override
    public Foo lookup(String fname, String sname){
        return this.factory.create(fname, sname);
    }
}