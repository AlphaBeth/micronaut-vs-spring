package com.alphabeth.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = Micronaut.run(Application.class, args);
    }
}
