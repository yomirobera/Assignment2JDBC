package no.accelerate.assignment2jdbc.repositories;

import no.accelerate.assignment2jdbc.Models.Customer;

import java.util.List;



public interface CustomerRepository extends CrudRepository<Integer, Customer> {
    /* Operation like update, delete, change, search ...


     */
    List<Customer> getAllByPhone(int Phone);
}
