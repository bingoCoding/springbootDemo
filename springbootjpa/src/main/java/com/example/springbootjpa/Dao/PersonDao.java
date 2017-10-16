package com.example.springbootjpa.Dao;

import com.example.springbootjpa.base.BaseDao;
import com.example.springbootjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonDao extends BaseDao<Person,Integer> {
    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name,String address);


    @Query("select p from Person p where p.name= :name and p.address= :address ")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    List<Person> withNameAndAddressNamedQuery(String name,String address);
}
