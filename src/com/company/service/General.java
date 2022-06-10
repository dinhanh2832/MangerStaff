package com.company.service;

public interface General<T> {
    int findIndexById(int id);

    void add(T t);

    void update(T t, int id);

    void deleteById(int id);

    void print();
}
