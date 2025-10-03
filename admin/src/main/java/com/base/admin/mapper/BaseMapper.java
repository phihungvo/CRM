package com.base.admin.mapper;

import java.util.Optional;

public interface BaseMapper<T, ID> {
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    long count();

    int deleteById(ID id);

    int delete(T entity);

    int deleteAllById(Iterable<? extends ID> ids);

    int deleteAll(Iterable<? extends T> entities);

    int deleteAll();
}
