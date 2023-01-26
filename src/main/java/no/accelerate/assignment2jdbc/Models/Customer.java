package no.accelerate.assignment2jdbc.Models;

//customer record
public record Customer(int customerId, String firstname, String lastname, String country, String postalcode, String phone,
                       String email) {


}
