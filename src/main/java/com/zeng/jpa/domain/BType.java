package com.zeng.jpa.domain;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BType extends Base{

    @Column(name ="age")
    private int age;

    public BType() {
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + "BType{" +
                "age=" + age +
                '}';
    }
}
