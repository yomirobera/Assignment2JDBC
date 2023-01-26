package no.accelerate.assignment2jdbc.repositories;

import java.util.List;

//Define a repository
public interface CrudRepository <T, U> {
    //crud
    List<T> findAll();
    T findById(U id);
    int insert(T object);
    void update(T object, U id);
}