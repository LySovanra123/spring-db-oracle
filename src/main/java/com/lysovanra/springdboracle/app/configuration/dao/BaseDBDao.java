package com.lysovanra.springdboracle.app.configuration.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public abstract class BaseDBDao<T, ID> implements IBaseDBDao<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected BaseDBDao() {
        this.entityClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T saveEntity(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<T> saveEntities(List<T> entities) {
        for (T entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    @Override
    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public void update(T entity, ID id) {
        entityManager.merge(entity);
    }
}