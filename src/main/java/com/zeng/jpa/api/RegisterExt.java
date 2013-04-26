package com.zeng.jpa.api;




import com.google.inject.persist.Transactional;
import com.zeng.jpa.domain.Base;
import com.zeng.jpa.domain.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class RegisterExt implements RegisterInterface {

    private EntityManager entityManager;


    @Inject
    public RegisterExt(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveInNewTransaction(Person object) {
        entityManager.persist(object);
    }


    public Person getByName(String name) {
        return (Person) entityManager
                .createQuery("select e from Person e where e.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public void saveBase(Base object) {
        entityManager.persist(object);
//        entityManager.flush();
    }

    public List<Base> getBase() {
        return entityManager
                .createQuery("select e from Base e ", Base.class)
                .getResultList();
    }

}
