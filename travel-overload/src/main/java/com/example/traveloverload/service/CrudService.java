package com.example.traveloverload.service;

import java.util.List;

public interface  CrudService<T,K extends Long> {
    List<T> getAll();
    T getById(K id);
    T saveOrUpdate(T t);
    boolean deleteById(K id);
}
