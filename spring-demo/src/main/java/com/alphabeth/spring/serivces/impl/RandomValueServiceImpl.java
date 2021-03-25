package com.alphabeth.spring.serivces.impl;

import com.alphabeth.spring.serivces.RandomValueService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomValueServiceImpl implements RandomValueService {

    private final RandomValueConfig randomValueConfig;

    @Override
    public int random() {
        return ThreadLocalRandom.current().nextInt(randomValueConfig.getMin(), randomValueConfig.getMax());
    }

    public RandomValueServiceImpl(RandomValueConfig randomValueConfig) {
        this.randomValueConfig = randomValueConfig;
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
