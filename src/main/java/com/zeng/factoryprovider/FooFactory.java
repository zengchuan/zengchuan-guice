package com.zeng.factoryprovider;

import com.google.inject.assistedinject.Assisted;

public interface FooFactory{
    public Foo create(String s);
}
