package com.alphabeth.spring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // should be runtime
@Target(ElementType.METHOD)
public @interface Loggable {
}
