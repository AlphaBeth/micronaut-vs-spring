package com.alphabeth.spring;

import com.alphabeth.spring.data.RelatedEntity;
import com.alphabeth.spring.data.TestEntity;
import com.alphabeth.spring.data.TestEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
public class SpringDataTest {
    @Autowired
    TestEntityRepository repository;

    @Transactional
    @Test
    void testLoadPage() {
        repository.save(new TestEntity(null, "1", Arrays.asList(new RelatedEntity())));
        repository.save(new TestEntity(null, "2", Collections.emptyList()));
        repository.save(new TestEntity(null, "3", Collections.emptyList()));
        repository.save(new TestEntity(null, "4", Collections.emptyList()));
        final Page<TestEntity> name = repository.findAll(PageRequest.of(1, 2, Sort.by(Sort.Order.desc("value"))));
        Assertions.assertEquals(4, name.getTotalElements());
        Assertions.assertEquals(name.getContent().size(), 2);
        Assertions.assertNotNull(name.getContent().get(0).getRelatedEntities());
        Assertions.assertNotNull(name.getContent().get(1).getRelatedEntities());
    }
}
