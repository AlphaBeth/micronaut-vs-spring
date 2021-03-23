package com.alphabeth.spring.conf;

import com.alphabeth.spring.serivces.TestService;
import com.alphabeth.spring.serivces.impl.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestServiceConf {
    @Bean
    public TestService testService() {
        return new TestServiceImpl();
    }
}
