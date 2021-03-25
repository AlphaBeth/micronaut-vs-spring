CREATE TABLE test_entity (
    id    BIGSERIAL PRIMARY KEY,
    value VARCHAR(512)
);

CREATE TABLE related_entity (
    id             UUID PRIMARY KEY,
    value          INT,
    test_entity_id BIGINT REFERENCES test_entity(id)
);
