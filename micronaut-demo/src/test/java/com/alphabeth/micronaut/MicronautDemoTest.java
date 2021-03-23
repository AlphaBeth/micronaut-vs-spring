package com.alphabeth.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class MicronautDemoTest {

    @Inject
    ApplicationContext application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
