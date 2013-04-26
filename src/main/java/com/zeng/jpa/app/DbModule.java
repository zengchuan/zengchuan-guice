package com.zeng.jpa.app;


import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.zeng.jpa.api.RegisterExt;
import com.zeng.jpa.api.RegisterInterface;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class DbModule extends AbstractModule {

    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE
            = new ThreadLocal<EntityManager>();

    public void configure() {
        install(new JpaPersistModule("db-manager").properties(toProperties()));
        bind(RegisterInterface.class).to(RegisterExt.class);
    }

    public Properties toProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        try {

            String value = "jdbc:h2:" + File.createTempFile("i0-db-driver", ".db").getAbsolutePath() + ";MODE=Oracle";
            System.out.println(value);
            properties.put("hibernate.connection.url", value);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        properties.put("hibernate.connection.username", "");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create");

        return properties;
    }

}
