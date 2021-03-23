package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public String answer() {
        return "42";
    }
}
