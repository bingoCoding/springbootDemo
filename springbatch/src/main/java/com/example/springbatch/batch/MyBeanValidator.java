package com.example.springbatch.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 自定义较检器
 * @param <T>
 */
public class MyBeanValidator<T> implements Validator<T>,InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> validates = validator.validate(t);
        if (validates.size()>0){
            StringBuilder sb=new StringBuilder();
            for (ConstraintViolation<T> constraintViolation:validates){
                sb.append(constraintViolation.getMessage()+"\n");
            }
            throw new ValidationException(sb.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}
