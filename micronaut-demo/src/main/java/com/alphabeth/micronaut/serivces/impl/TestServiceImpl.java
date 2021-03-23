package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.TestService;
import io.micronaut.context.annotation.Prototype;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Prototype
@Slf4j
public class TestServiceImpl implements TestService {
    @Override
    public String answer() {
        return "42";
    }

    public TestServiceImpl() {
        log.info("{} was created", this.getClass().getName());
    }

    @PostConstruct
    public void init() {
        log.info("Post construct method of {} was invoked", this.getClass().getName());
    }

    @PreDestroy
    public void destroy() {
        log.info("Pre destroy method of {} was invoked", this.getClass().getName());
    }
}
