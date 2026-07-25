package com.lysovanra.springdboracle.app.configuration.dao;

import java.util.List;

public interface IBaseDBDao<T, ID> {
    T findById(ID id);
    List<T> findAll();
    T saveEntity(T entity);
    List<T> saveEntities(List<T> entities);
    void deleteById(ID id);
    void update(T entity, ID id);
}
