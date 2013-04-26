package com.zeng.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.zeng.jpa.app.DbModule;
import com.zeng.jpa.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class H2DBTest {
    @Test
    public void testDb() throws SQLException {
        Injector injector = Guice.createInjector(new DbModule());

        PersistService persistService = injector.getInstance(PersistService.class);
        persistService.start();

        EntityManagerFactory entityManagerFactory = injector.getInstance(EntityManagerFactory.class);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person = new Person();
        person.setName("zeng");
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        Person retrieved =(Person) entityManager
                .createQuery("select e from Person e where e.name=:name")
                .setParameter("name", "zeng")
                .getSingleResult();

        assertThat(person.getName(), is("zeng"));

        entityManager.close();
        entityManagerFactory.close();
        persistService.stop();
    }

}
