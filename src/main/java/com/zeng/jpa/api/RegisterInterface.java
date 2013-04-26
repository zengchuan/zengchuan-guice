package com.zeng.jpa.api;




import com.zeng.jpa.domain.Base;
import com.zeng.jpa.domain.Person;

import java.util.List;

public interface RegisterInterface {


    public void saveInNewTransaction(Person object);


    public Person getByName(String name);

    public void saveBase(Base object);

    public List<Base> getBase();
}
