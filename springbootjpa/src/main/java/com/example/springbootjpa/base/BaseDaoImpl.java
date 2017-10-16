package com.example.springbootjpa.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.example.springbootjpa.base.BaseSpecification.*;

public class BaseDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseDao<T,ID> {

    private final EntityManager em;

    public BaseDaoImpl(Class<T> domainClass,EntityManager em){
        super(domainClass,em);
        this.em=em;
    }
    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(em,example),pageable);
    }
}
