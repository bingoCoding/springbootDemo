package com.example.springmvc.springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person findByUsername(String s);
}
