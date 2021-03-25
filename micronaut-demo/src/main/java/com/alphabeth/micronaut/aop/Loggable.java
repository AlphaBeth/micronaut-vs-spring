package com.alphabeth.micronaut.aop;

import io.micronaut.aop.Around;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // should be runtime
@Target(ElementType.METHOD)
@Around // around method invocation
public @interface Loggable {
}
