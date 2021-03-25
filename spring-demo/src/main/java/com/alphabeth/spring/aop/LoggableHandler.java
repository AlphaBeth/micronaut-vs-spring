package com.alphabeth.spring.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Aspect
@Slf4j
@Service
public class LoggableHandler {
    @SneakyThrows
    @Around("@annotation(Loggable)")
    public Object intercept(ProceedingJoinPoint joinPoint) {

        log.debug("Method: {}, args: {}", joinPoint.getSignature(), joinPoint.getArgs());
        final Object result = joinPoint.proceed();
        log.debug("Return value: {}", result);
        return result;
    }
}
