package com.alphabeth.spring.serivces.impl;


import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;

public class MultipleConstructorTestService implements TestService {

    private final RandomValueService randomValueService;

    public MultipleConstructorTestService(RandomValueService randomValueService) {
        this.randomValueService = randomValueService;
    }

    @Override
    public String answer() {
        return "Another " + randomValueService.random();
    }
}
