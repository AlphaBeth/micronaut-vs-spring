package com.alphabeth.spring.serivces.impl;

import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// bean names can be automatically generated
@Service
public class FieldInjectionTestService implements TestService {

    @Autowired // field injection
    private RandomValueService randomValueService;

    @Override
    public String answer() {
        return "Yet another " + randomValueService.random();
    }
}
