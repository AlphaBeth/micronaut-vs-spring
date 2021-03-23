# My own Spring and Micronaut comparison

## Demo 1. Sample empty project

Let's look how to create sample project.

### Spring (Boot) 

Spring provides [Spring Initializer](https://start.spring.io/) site to init project. 
You can choose Spring Boot version, build tool (Maven or Gradle), language (Java, Kotlin, Groovy),
give a name to your project, add optional dependencies.

Then you have to create simple entry point
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
```

`@SpringBootApplication` enables auto configuration of your application, so all components/configurations 
from classpath will be scanned and loaded.

Then write test which checks that Spring's application context is loaded.

```java
@SpringBootTest
class ApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testApplicationContextLoads() {
        assertNotNull(applicationContext);
    }
}
```

### Micronaut

I have deja vu.

You can create Micronaut application at [Micronaut Launch](https://micronaut.io/launch/).

Entry point looks almost same as Spring Boot's.
```java
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
```

Micronaut also has ApplicationContext which we check in our test, that looks similar to Spring Boot.
```java
@MicronautTest
class MicronautDemoTest {

    @Inject
    ApplicationContext application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
```

Main difference in Spring Boot and Micronaut at this point is build configuration. Spring Boot scans
your application code at runtime to create components, proxies and so on. Micronaut makes a lot of work
at compile time to avoid reflection and runtime proxies, so we need to add some annotation processors
to our code.

## Demo 2. Creating beans with annotations. Scopes.

Spring have a lot of configuration methods: annotation based, source code config, groovy config, xml... In Micronaut
only annotation based/source code configs are present. It's because of Microunaut's nature - it generates
Java classes for bean definitions, and they register themselves in static initialize blocks.

| Micronaut | Spring |   |
|-----------|--------|---|
| @javax.inject.Singleton | @org.springframework.stereotype.Component or @org.springframework.stereotype.Service + @org.springframework.context.annotation.Lazy   | Singletons are lazy by default in micronaut, eager initialization can be forced with Micronaut.build(args).eagerInitSingletons(true) |
| @io.micronaut.context.annotation.Context | @org.springframework.stereotype.Component or @org.springframework.stereotype.Service | Same as Singleton, but eager |
| @io.micronaut.context.annotation.Prototype | @org.springframework.context.annotation.Scope("protype") + Service/Component | Prototypes are created when requested |
| @io.micronaut.context.annotation.Infrastructure | ??? | Infrastructure components can't be overridden |
| @io.micronaut.runtime.context.scope.ThreadLocal | @io.micronaut.runtime.context.scope.ThreadLocal |  |
| @io.micronaut.runtime.context.scope.Refreshable | ~ @org.springframework.cloud.context.config.annotation.RefreshScope | Spring's refresh scope is Spring Cloud specific. Beans are recreated on specific events. |
| @io.micronaut.runtime.http.scope.RequestScope | @Scope("request") |  |
