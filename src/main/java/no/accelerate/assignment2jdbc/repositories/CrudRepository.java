package no.accelerate.assignment2jdbc.repositories;

import no.accelerate.assignment2jdbc.Models.Customer;
import no.accelerate.assignment2jdbc.Models.CustomerCountry;
import no.accelerate.assignment2jdbc.Models.CustomerGenre;
import no.accelerate.assignment2jdbc.Models.CustomerSpender;

import java.util.List;

public interface CrudRepository <T, U> {
    //crud
    List<T> findAll();
    CustomerCountry countryMostCustomers();
    CustomerSpender highestSpender();
    List<CustomerGenre> mostPopularGenre(Customer customer);
    int insert(T object);
    void create (T object);
    void update(T object, int id);
    void deleteById(U id);

    void getCustomerById(int id);

    void getCustomerByName(String firstName, String lastName);

    List<Customer> pageOfCustomers(int limit, int offset);
}
