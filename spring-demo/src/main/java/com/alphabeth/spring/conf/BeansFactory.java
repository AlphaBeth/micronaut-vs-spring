package com.alphabeth.spring.conf;

import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import com.alphabeth.spring.serivces.impl.FieldInjectionTestService;
import com.alphabeth.spring.serivces.impl.MethodInjectionTestService;
import com.alphabeth.spring.serivces.impl.MultipleConstructorTestService;
import com.alphabeth.spring.serivces.impl.RandomValueConfig;
import com.alphabeth.spring.serivces.impl.RandomValueServiceImpl;
import com.alphabeth.spring.serivces.impl.TestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.Collections;

@Configuration
@AllArgsConstructor
public class BeansFactory {

    private final RandomValueConfig randomValueConfig;

    @Bean
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

    @Bean("another")
    public TestService testService(
            RandomValueService randomValueService
    ) {
        return new MultipleConstructorTestService(randomValueService);
    }

    @Primary
    @Bean
    @Scope("prototype")
    public TestService defaultTestService() {
        return new TestServiceImpl(testService()); // proxy method invocation
    }

    @Bean
    public RandomValueService testService() {
        return new RandomValueServiceImpl(randomValueConfig);
    }
}
