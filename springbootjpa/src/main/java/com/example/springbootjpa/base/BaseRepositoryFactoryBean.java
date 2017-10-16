package com.example.springbootjpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryFactoryBean<T extends JpaRepository<S,ID>,S,ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID>{

    public BaseRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseRepositoryFactory(entityManager);
    }

    private static class BaseRepositoryFactory extends JpaRepositoryFactory {

        public BaseRepositoryFactory(EntityManager entityManager){
            super(entityManager);
        }

        @Override
        @SuppressWarnings({"unchecked"})
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            return new BaseDaoImpl<T,ID>((Class<T>)information.getDomainType(), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseDaoImpl.class;
        }
    }
}
