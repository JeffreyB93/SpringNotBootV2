package org.example.service;

import java.util.List;

public interface Service<T, K> {

    T save(T t);

    T findById(K id);

    List<T> findAll();

    boolean deleteById(K id);
}
