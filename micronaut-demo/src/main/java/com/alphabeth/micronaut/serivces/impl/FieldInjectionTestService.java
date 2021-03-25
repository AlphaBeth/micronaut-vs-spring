package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;

import javax.inject.Inject;
import javax.inject.Singleton;

// bean names can be automatically generated
@Singleton
public class FieldInjectionTestService implements TestService {

    @Inject // field injection
    private RandomValueService randomValueService;

    @Override
    public String answer() {
        return "Yet another " + randomValueService.random();
    }
}
