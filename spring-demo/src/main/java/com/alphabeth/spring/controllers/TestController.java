package com.alphabeth.spring.controllers;

import com.alphabeth.spring.data.TestEntity;
import com.alphabeth.spring.data.TestEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    private final TestEntityRepository testEntityRepository;

    @GetMapping
    public Page<TestEntity> get(Pageable page) {
        return testEntityRepository.findAll(page);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TestEntity save(TestEntity testEntity) {
        return testEntityRepository.save(testEntity);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TestEntity update(
            @PathVariable("id") long entityId,
            TestEntity testEntity
    ) {
        if (!Objects.equals(entityId, testEntity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Path and body ids not equal");
        }
        return testEntityRepository.save(testEntity);
    }

    @DeleteMapping("/{id}")
    public TestEntity delete(@PathVariable("id") long entityId) {
        final TestEntity foundEntity = testEntityRepository
                .findById(entityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        testEntityRepository.delete(foundEntity);
        return foundEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long entityId) {
        return testEntityRepository
                .findById(entityId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
