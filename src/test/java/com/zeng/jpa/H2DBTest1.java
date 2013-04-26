package com.zeng.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.zeng.jpa.api.RegisterInterface;
import com.zeng.jpa.app.DbModule;
import com.zeng.jpa.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class H2DBTest1 {
    @Test
    public void testDb() throws SQLException {
        Injector injector = Guice.createInjector(new DbModule());

        PersistService persistService = injector.getInstance(PersistService.class);
        persistService.start();

        RegisterInterface registerInterface = injector.getInstance(RegisterInterface.class);

        Person person1 = new Person();
        person1.setName("zeng1");
        registerInterface.saveInNewTransaction(person1);

        Person person2 = new Person();
        person2.setName("zeng2");
        registerInterface.saveInNewTransaction(person2);

        Person retrieved = registerInterface.getByName("zeng1") ;

        assertThat(retrieved.getName(), is("zeng1"));

        injector.getInstance(EntityManager.class).close();
        persistService.stop();
    }

}
