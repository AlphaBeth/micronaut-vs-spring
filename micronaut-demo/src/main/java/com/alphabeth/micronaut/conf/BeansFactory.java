package com.alphabeth.micronaut.conf;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;
import com.alphabeth.micronaut.serivces.impl.FieldInjectionTestService;
import com.alphabeth.micronaut.serivces.impl.MethodInjectionTestService;
import com.alphabeth.micronaut.serivces.impl.MultipleConstructorTestService;
import com.alphabeth.micronaut.serivces.impl.RandomValueConfig;
import com.alphabeth.micronaut.serivces.impl.RandomValueServiceImpl;
import com.alphabeth.micronaut.serivces.impl.TestServiceImpl;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collections;

@Factory
public class BeansFactory {

    @Bean
    @Singleton // prototypes by default
    @Named("random")
    public TestService random(
            RandomValueService randomValueService // inject service
    ) {
        if (Math.random() > 0.5) {
            final MethodInjectionTestService methodInjectionTestService = new MethodInjectionTestService();
            // have to manually inject dependencies
            methodInjectionTestService.injectServices(Collections.singletonList(randomValueService));
            return methodInjectionTestService;
        } else {
            final FieldInjectionTestService fieldInjectionTestService = new FieldInjectionTestService();
            fieldInjectionTestService.randomValueService = randomValueService;
            return fieldInjectionTestService;
        }
    }

    @Named("another") // give name to bean
    @Singleton
    public TestService testService(
            RandomValueService randomValueService
    ) {
        return new MultipleConstructorTestService(randomValueService);
    }

    @Primary // primary beans will be used if multiple candidates are present in context
    @Bean
    public TestService defaultTestService(
            RandomValueService randomValueService
    ) {
        return new TestServiceImpl(randomValueService);
    }

    @Bean
    @Singleton
    public RandomValueService testService(
            RandomValueConfig randomValueConfig
    ) {
        return new RandomValueServiceImpl(randomValueConfig);
    }
}
