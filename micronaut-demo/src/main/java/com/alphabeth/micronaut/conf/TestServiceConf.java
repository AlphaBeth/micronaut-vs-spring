package com.alphabeth.micronaut.conf;

import com.alphabeth.micronaut.serivces.TestService;
import com.alphabeth.micronaut.serivces.impl.TestServiceImpl;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class TestServiceConf {
    @Bean
    @Singleton
    public TestService testService() {
        return new TestServiceImpl();
    }
}
