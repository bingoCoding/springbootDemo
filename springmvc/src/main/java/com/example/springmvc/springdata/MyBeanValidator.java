package com.example.springmvc.springdata;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class MyBeanValidator<T> implements Validator<T>,InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}
