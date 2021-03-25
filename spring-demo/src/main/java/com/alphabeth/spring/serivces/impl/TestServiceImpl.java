package com.alphabeth.spring.serivces.impl;


import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary // primary beans will be used if multiple candidates are present in context
@Scope("prototype")
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    private final RandomValueService randomValueService;
    @Override
    public String answer() {
        return "Primary" + randomValueService.random();
    }

    // if class has single constructor then it will be used for injection
    public TestServiceImpl(RandomValueService randomValueService) {
        this.randomValueService = randomValueService;
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
