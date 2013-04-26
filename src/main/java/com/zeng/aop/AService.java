package com.zeng.aop;

import org.springframework.cache.annotation.Cacheable;

public class AService implements Service {
    public void test(){
        System.out.println("A tested!");
    }
}
