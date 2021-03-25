package com.alphabeth.micronaut.data;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedEntity
@Getter
@Setter
public class RelatedEntity {
    @Id
    @AutoPopulated
    private UUID id;

    private int value;

    @Relation(Relation.Kind.MANY_TO_ONE)
    private TestEntity testEntity;
}
