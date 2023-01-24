package no.accelerate.assignment2jdbc.repositories;

import java.util.List;

public interface CrudRepository <T, U> {
    //crud
    List<T> findAll();
    T getById(U id);
    int insert(T object);
    void create (T object);
    void update(T object);
    void deleteById(U id);

}
