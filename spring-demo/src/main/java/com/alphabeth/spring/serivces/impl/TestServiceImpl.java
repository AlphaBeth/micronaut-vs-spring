package com.alphabeth.spring.serivces.impl;


import com.alphabeth.spring.serivces.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
@Service
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
