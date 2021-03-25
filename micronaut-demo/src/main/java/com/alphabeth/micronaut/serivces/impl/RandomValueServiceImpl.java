package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomValueServiceImpl implements RandomValueService {

    public RandomValueServiceImpl() {
        log.info("{} was created", this.getClass().getName());
    }

    @Override
    public int random() {
        return ThreadLocalRandom.current().nextInt(0, 42);
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
