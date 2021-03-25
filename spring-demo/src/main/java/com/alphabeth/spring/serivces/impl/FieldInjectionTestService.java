package com.alphabeth.spring.serivces.impl;

import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;


public class FieldInjectionTestService implements TestService {

    public RandomValueService randomValueService;

    @Override
    public String answer() {
        return "Yet another " + randomValueService.random();
    }
}
