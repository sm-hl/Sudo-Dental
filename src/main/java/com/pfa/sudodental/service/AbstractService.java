package com.pfa.sudodental.service;


import com.pfa.sudodental.model.AbstractModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractModel<Long>, Long extends Serializable> {

    protected abstract JpaRepository<T, Long> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public T get(Long id) {
        Optional<T> entityOpt = getRepository().findById(id);
        T entity = entityOpt.get();
        return entity;
    }

    public void delete(Long id) {
        try {
            getRepository().deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }

    public void update(T entity) {
        Optional<T> getEntityOpt = getRepository().findById(entity.getId());
        T getEntity = getEntityOpt.get();
        getRepository().save(entity);
    }

}