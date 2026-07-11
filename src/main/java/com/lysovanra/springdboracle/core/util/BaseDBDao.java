package com.lysovanra.springdboracle.core.util;

import com.lysovanra.springdboracle.app.configuration.IBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseDBDao<T, TD> {
    protected IBaseRepository<T, TD> repository;
    public BaseDBDao(IBaseRepository<T, TD> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(TD id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }
}
