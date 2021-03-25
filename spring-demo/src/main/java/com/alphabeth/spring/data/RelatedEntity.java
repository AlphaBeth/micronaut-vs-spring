package com.alphabeth.spring.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
public class RelatedEntity {
    @Id
    private UUID id;

    private int value;

    private Long testEntityId;
}
