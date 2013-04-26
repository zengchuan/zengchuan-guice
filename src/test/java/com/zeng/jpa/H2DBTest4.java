package com.zeng.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.zeng.jpa.api.RegisterInterface;
import com.zeng.jpa.app.DbModule;
import com.zeng.jpa.domain.AType;
import com.zeng.jpa.domain.BType;
import com.zeng.jpa.domain.Base;
import com.zeng.jpa.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class H2DBTest4 {
    @Test
    public void testDb() throws SQLException {
        Injector injector = Guice.createInjector(new DbModule());

        PersistService persistService = injector.getInstance(PersistService.class);
        persistService.start();

        RegisterInterface registerInterface = injector.getInstance(RegisterInterface.class);

        AType aType = new AType();
        aType.setName("zeng");
        registerInterface.saveBase(aType);

        BType bType = new BType();
        bType.setAge(1);
        registerInterface.saveBase(bType);

        injector.getInstance(EntityManager.class).clear();
        List<Base> baseList = registerInterface.getBase() ;

        for(Base base : baseList){
            System.out.println(base.toString());
        }

        injector.getInstance(EntityManager.class).close();
        persistService.stop();
    }

}
