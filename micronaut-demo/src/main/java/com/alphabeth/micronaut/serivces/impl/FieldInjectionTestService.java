package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;

public class FieldInjectionTestService implements TestService {

    public RandomValueService randomValueService;

    @Override
    public String answer() {
        return "Yet another " + randomValueService.random();
    }
}
