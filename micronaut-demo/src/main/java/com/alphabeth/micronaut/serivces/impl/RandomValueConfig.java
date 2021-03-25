package com.alphabeth.micronaut.serivces.impl;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.bind.annotation.Bindable;

@ConfigurationProperties("random.service")
public interface RandomValueConfig {
    @Bindable(defaultValue = "0")
    int getMin();
    @Bindable(defaultValue = "42")
    int getMax();
}
