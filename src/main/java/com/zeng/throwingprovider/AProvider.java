package com.zeng.throwingprovider;

import com.google.inject.Provider;

import java.util.Properties;

public class AProvider implements GeneralProVider<Service> {

    @Override
    public Service get() throws Exception{
        Properties prop = new Properties();
        prop.load(AProvider.class.getResourceAsStream("test.properties"));
        return new ServiceImpl(prop);
    }
}
