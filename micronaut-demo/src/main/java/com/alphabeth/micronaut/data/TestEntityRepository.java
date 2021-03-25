package com.alphabeth.micronaut.data;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TestEntityRepository extends PageableRepository<TestEntity, Long> {

    @Join(value = "relatedEntities", type = Join.Type.LEFT_FETCH)
    Page<TestEntity> findAll(Pageable page);
}
