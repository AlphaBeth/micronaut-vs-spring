package com.alphabeth.micronaut.controllers;

import com.alphabeth.micronaut.data.TestEntity;
import com.alphabeth.micronaut.data.TestEntityRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.exceptions.HttpStatusException;
import lombok.AllArgsConstructor;

import javax.annotation.Nonnull;
import java.util.Objects;

@AllArgsConstructor
@Controller(value = "/test", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class TestController {

    private final TestEntityRepository testEntityRepository;

    @Get
    public Page<TestEntity> get(Pageable page) {
        return testEntityRepository.findAll(page);
    }

    @Post
    public TestEntity save(TestEntity testEntity) {
        return testEntityRepository.save(testEntity);
    }

    @Put("/{id}")
    public TestEntity update(
            @PathVariable("id") long entityId,
            @Nonnull TestEntity testEntity
    ) {
        if (!Objects.equals(entityId, testEntity.getId())) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Path and body ids not equal");
        }
        return testEntityRepository.save(testEntity);
    }

    @Delete("/{id}")
    public TestEntity delete(@PathVariable("id") long entityId) {
        final TestEntity foundEntity = testEntityRepository
                .findById(entityId)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "not found"));
        testEntityRepository.delete(foundEntity);
        return foundEntity;
    }

    @Get("/{id}")
    public HttpResponse<?> get(@PathVariable("id") long entityId) {
        return testEntityRepository
                .findById(entityId)
                .map(HttpResponse::ok)
                .orElseGet(HttpResponse::notFound);
    }
}
