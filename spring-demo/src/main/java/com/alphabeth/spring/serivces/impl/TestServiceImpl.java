package com.alphabeth.spring.serivces.impl;


import com.alphabeth.spring.serivces.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public String answer() {
        return "42";
    }
}
