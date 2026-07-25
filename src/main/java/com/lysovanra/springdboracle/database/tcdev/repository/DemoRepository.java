package com.lysovanra.springdboracle.database.tcdev.repository;

import com.lysovanra.springdboracle.app.configuration.database.IBaseRepository;
import com.lysovanra.springdboracle.database.tcdev.entity.DemoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends IBaseRepository<DemoEntity, Long> {
}
