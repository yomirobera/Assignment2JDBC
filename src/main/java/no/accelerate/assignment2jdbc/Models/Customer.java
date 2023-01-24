package no.accelerate.assignment2jdbc.Models;

public record Customer(String customerId, String firstname, String lastname, String country, String postalcode, String phone,
                       String email) {
}
