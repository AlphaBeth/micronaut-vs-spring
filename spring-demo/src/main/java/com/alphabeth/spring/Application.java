package com.alphabeth.spring;

import com.alphabeth.spring.serivces.RandomValueService;
import com.alphabeth.spring.serivces.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class)) {
            System.out.println(applicationContext.getBean(RandomValueService.class).random());
            System.out.println(applicationContext.getBean(TestService.class).answer());
            System.out.println(applicationContext.getBean(TestService.class).answer());
            System.out.println(applicationContext.getBean("another", TestService.class).answer());
            System.out.println(applicationContext.getBean("random", TestService.class).answer());
        }
    }
}
