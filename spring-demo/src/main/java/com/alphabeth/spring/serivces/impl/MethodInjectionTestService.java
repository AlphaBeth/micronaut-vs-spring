package com.alphabeth.spring.serivces.impl;

import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodInjectionTestService implements TestService {

    @Override
    public String answer() {
        return "Method injection";
    }

    @Autowired // method injection
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
