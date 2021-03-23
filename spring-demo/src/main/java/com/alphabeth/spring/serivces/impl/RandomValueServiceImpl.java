package com.alphabeth.spring.serivces.impl;

import com.alphabeth.spring.serivces.RandomValueService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomValueServiceImpl implements RandomValueService {
    @Override
    public int random() {
        return ThreadLocalRandom.current().nextInt(0, 42);
    }
}
