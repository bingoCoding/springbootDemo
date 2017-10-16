package com.example.springbootjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
        query = "select p from Person p where p.name= ?1 and p.address= ?2 ")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
