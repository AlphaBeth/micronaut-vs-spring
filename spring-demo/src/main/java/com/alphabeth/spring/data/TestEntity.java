package com.alphabeth.spring.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    private Long id;

    private String value;

    @MappedCollection(idColumn = "test_entity_id")
    private Set<RelatedEntity> relatedEntities;
}
