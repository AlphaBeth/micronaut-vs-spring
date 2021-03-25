package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;

import java.util.List;

public class MethodInjectionTestService implements TestService {

    @Override
    public String answer() {
        return "Method injection";
    }

    public void injectServices(
            List<RandomValueService> services // lists can be injected
    ) {
        System.out.println("List of services");
        services
                .stream()
                .map(RandomValueService::random)
                .forEach(System.out::println);
    }
}
