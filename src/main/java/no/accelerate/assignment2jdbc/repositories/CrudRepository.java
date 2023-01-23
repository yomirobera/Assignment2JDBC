package no.accelerate.assignment2jdbc.repositories;

import java.util.List;

public interface CrudRepository <ID, T> {
    //crud
    T getById(ID id);
    List<T> getAll();
    void create (T object);
    void update(T object);
    void delete(ID id);

}
