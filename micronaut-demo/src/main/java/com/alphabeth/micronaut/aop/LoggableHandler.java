package com.alphabeth.micronaut.aop;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Singleton
@InterceptorBean(Loggable.class)
@Slf4j
public class LoggableHandler implements MethodInterceptor<Object, Object> {
    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        log.debug("Method: {}, args: {}", context.getMethodName(), context.getArguments());
        final Object result = context.proceed();
        log.debug("Return value: {}", result);
        return result;
    }
}
