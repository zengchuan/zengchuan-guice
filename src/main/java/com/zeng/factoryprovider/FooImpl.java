package com.zeng.factoryprovider;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class FooImpl implements Foo{
    private int num;
    private String color;
    private String name;

    @Inject
    public FooImpl(int num
            , String color
            , @Assisted String name){
        this.num = num;
        this.color = color;
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getNum(){
        return this.num;
    }
    @Override
    public String getColor(){
        return this.color;
    }
}