package com.zeng.assistedinject;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class FooImpl implements Foo {
    private int num;
    private String color;
    private String fname;
    private String sname;

    @Inject
    public FooImpl(int num
            ,String color
            ,@Assisted("First")  String fname
            ,@Assisted("Second") String sname){
        this.num = num;
        this.color = color;
        this.fname = fname;
        this.sname = sname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}