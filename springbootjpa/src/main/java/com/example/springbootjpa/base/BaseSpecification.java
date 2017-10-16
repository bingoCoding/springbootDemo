package com.example.springbootjpa.base;

import static com.google.common.collect.Iterables.toArray;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseSpecification {
    public static <T>Specification<T> byAuto(EntityManager em,final T example){

        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = em.getMetamodel().entity(type);
                for(Attribute<T,?> attr:entity.getDeclaredAttributes()){
                    Object attrValue = getAttrValue(example,attr);
                    if (attrValue!=null){
                        if(attr.getJavaType()==String.class){
                            if (!StringUtils.isEmpty(attrValue)){
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)),
                                        pattern((String)attrValue)));
                            }
                        }else{
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),
                                    attrValue));
                        }

                    }

                }
                return predicates.isEmpty()?cb.conjunction():cb.and(toArray(predicates,Predicate.class));
            }

            private <E,T>SingularAttribute<T,E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName,fieldClass);
            }

            private <T> Object getAttrValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field)attr.getJavaMember(),example);
            }

            private String pattern(String str){
                return "%"+str+"%";
            }
        };
    }
}
