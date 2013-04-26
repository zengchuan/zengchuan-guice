package com.zeng.jpa.domain;


import javax.persistence.*;

@Entity
@Table(name = "base")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Base {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="type", insertable = false, updatable = false)
    private String type;

    public Base() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
