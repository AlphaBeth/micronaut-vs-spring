package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;

import javax.inject.Named;
import javax.inject.Singleton;

@Named("another") // give name to bean
@Singleton
public class MultipleConstructorTestService implements TestService {

    private final RandomValueService randomValueService;

    public MultipleConstructorTestService(RandomValueService randomValueService) {
        this.randomValueService = randomValueService;
    }

    public MultipleConstructorTestService() {
        this.randomValueService = new RandomValueServiceImpl();
    }

    @Override
    public String answer() {
        return "Another " + randomValueService.random();
    }
}
