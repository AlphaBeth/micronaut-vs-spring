package com.alphabeth.spring.serivces.impl;


import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import org.springframework.stereotype.Service;

@Service("another") // give a name to bean
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