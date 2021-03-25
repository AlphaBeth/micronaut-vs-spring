package com.alphabeth.spring.serivces.impl;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "random.service")
public class RandomValueConfig {

    private int min = 0;
    private int max = 42;
}
