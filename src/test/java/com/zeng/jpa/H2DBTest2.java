package com.zeng.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.zeng.jpa.app.DbModule;
import com.zeng.jpa.domain.AType;
import com.zeng.jpa.domain.BType;
import com.zeng.jpa.domain.Base;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

public class H2DBTest2 {
    @Test
    public void testDb() throws SQLException {
        Injector injector = Guice.createInjector(new DbModule());

        PersistService persistService = injector.getInstance(PersistService.class);
        persistService.start();

        EntityManagerFactory entityManagerFactory = injector.getInstance(EntityManagerFactory.class);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AType aType = new AType();
        aType.setName("zeng");
        entityManager.persist(aType);
        BType bType = new BType();
        bType.setAge(1);
        entityManager.persist(bType);
        entityManager.getTransaction().commit();
//        entityManager.clear();
//        entityManager.close();
//        entityManager = entityManagerFactory.createEntityManager();

        System.out.println(bType.getType());
        List<Base>  baseList = entityManager
                .createQuery("select e from Base e ", Base.class)
                .getResultList();
        for(Base base : baseList){
            System.out.println(base.toString());
        }
        entityManager.close();
        persistService.stop();
    }

}
