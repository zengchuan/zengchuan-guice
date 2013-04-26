package com.zeng.throwingprovider;

import java.util.Properties;

public class ServiceImpl implements Service{
    private Properties prop;

    protected ServiceImpl(Properties prop){
        this.prop = prop;
    }

    @Override
    public String getValue(String key){
        return this.prop.getProperty(key);
    }
}
