package com.example.spring.aspectj;

import java.lang.annotation.*;

/**
 * 拦截规则的注解
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
