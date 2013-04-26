package com.zeng.assistedinject;

import com.google.inject.assistedinject.Assisted;

public interface FooFactory{
    public Foo create(@Assisted("First") String fname
            ,@Assisted("Second") String sname);
}
