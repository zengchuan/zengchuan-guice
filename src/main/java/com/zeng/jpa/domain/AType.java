package com.zeng.jpa.domain;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class AType extends Base {

    @Column(name ="name")
    private String name;

    public AType() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "AType{" +
                "name='" + name + '\'' +
                '}';
    }
}
