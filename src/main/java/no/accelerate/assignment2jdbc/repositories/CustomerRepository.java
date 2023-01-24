package no.accelerate.assignment2jdbc.repositories;

import no.accelerate.assignment2jdbc.Models.Customer;

import java.util.List;



public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    /* Operation like update, delete, change, search ...
    //Extended methods

     */
    List<Customer> findAll();

    void getCustomerById(int id);

    void getCustomerByName(String firstName, String lastName);

    List<Customer> pageOfCustomers(int limit, int offset);
}
