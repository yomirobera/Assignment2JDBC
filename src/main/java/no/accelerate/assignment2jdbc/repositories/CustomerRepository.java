package no.accelerate.assignment2jdbc.repositories;

import no.accelerate.assignment2jdbc.Models.Customer;
import no.accelerate.assignment2jdbc.Models.CustomerCountry;
import no.accelerate.assignment2jdbc.Models.CustomerGenre;
import no.accelerate.assignment2jdbc.Models.CustomerSpender;

import java.util.List;

/**
 * Includes operations such as Insert, Update, Search..
 */
    //Extended methods

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    /* Operation like update, delete, change, search ...
    //Extended methods

     */
    List<Customer> findAll();
    Customer findById(Integer id);
    int insert(Customer customer);
    void update(Customer customer, Integer id);


    CustomerCountry countryMostCustomers();
    CustomerSpender highestSpender();
    List<CustomerGenre> mostPopularGenre(int id);
    Customer getCustomerByName(String firstName, String lastName);
    List<Customer> pageOfCustomers(int limit, int offset);
}
