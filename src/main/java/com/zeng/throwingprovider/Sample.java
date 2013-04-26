package com.zeng.throwingprovider;

import com.google.inject.Inject;

public class Sample {
    @Inject
    AProvider provider;

    public void exec(){
        try{
            Service service = this.provider.get();
            String v = service.getValue("a");
            System.out.println("v = " + v);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
