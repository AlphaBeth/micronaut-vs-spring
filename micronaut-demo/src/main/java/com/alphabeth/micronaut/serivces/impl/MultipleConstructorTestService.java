package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.aop.Loggable;
import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;

public class MultipleConstructorTestService implements TestService {

    private final RandomValueService randomValueService;

    public MultipleConstructorTestService(RandomValueService randomValueService) {
        this.randomValueService = randomValueService;
    }

    @Override
    @Loggable
    public String answer() {
        return "Another " + randomValueService.random();
    }
}
