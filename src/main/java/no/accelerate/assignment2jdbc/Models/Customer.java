package no.accelerate.assignment2jdbc.Models;

public record Customer(int customerId, String firstName, String lastName, String country, int postalCode, int phone,
                       String email) {
}
