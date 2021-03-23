package com.alphabeth.micronaut.serivces.impl;

import com.alphabeth.micronaut.serivces.RandomValueService;

import javax.inject.Singleton;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class RandomValueServiceImpl implements RandomValueService {

    @Override
    public int random() {
        return ThreadLocalRandom.current().nextInt(0, 42);
    }
}
