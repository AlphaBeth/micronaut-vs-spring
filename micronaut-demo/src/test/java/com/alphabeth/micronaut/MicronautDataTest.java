package com.alphabeth.micronaut;

import com.alphabeth.micronaut.data.RelatedEntity;
import com.alphabeth.micronaut.data.TestEntity;
import com.alphabeth.micronaut.data.TestEntityRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;

@MicronautTest
public class MicronautDataTest {
    @Inject
    TestEntityRepository repository;

    @Transactional
    @Test
    void testLoadPage() {
        repository.save(new TestEntity(null, "1", Arrays.asList(new RelatedEntity())));
        repository.save(new TestEntity(null, "2", Collections.emptyList()));
        repository.save(new TestEntity(null, "3", Collections.emptyList()));
        repository.save(new TestEntity(null, "4", Collections.emptyList()));
        final Page<TestEntity> name = repository.findAll(Pageable.from(1, 2, Sort.of(Sort.Order.desc("value"))));
        Assertions.assertEquals(4, name.getTotalSize());
        Assertions.assertEquals(name.getContent().size(), 2);
        Assertions.assertNotNull(name.getContent().get(0).getRelatedEntities());
        Assertions.assertNotNull(name.getContent().get(1).getRelatedEntities());
    }
}
