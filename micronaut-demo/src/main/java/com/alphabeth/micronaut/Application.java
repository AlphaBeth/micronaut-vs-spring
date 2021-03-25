package com.alphabeth.micronaut;

import com.alphabeth.micronaut.serivces.RandomValueService;
import com.alphabeth.micronaut.serivces.TestService;
import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        try (final ApplicationContext applicationContext = Micronaut.run(Application.class, args)) {
            System.out.println(applicationContext.getBean(RandomValueService.class).random());
            System.out.println(applicationContext.getBean(TestService.class).answer());
            System.out.println(applicationContext.getBean(TestService.class).answer());
            System.out.println(applicationContext.getBean(TestService.class, Qualifiers.byName("another")).answer());
            System.out.println(applicationContext.getBean(TestService.class, Qualifiers.byName("random")).answer());
        }
    }
}
