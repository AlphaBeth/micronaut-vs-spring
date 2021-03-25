package com.alphabeth.spring.data;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TestEntityRepository extends PagingAndSortingRepository<TestEntity, Long> {

}
