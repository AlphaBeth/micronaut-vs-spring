package com.alphabeth.micronaut.data;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.List;

@MappedEntity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String value;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "testEntity", cascade = Relation.Cascade.ALL)
    @Nullable
    private List<RelatedEntity> relatedEntities;
}
