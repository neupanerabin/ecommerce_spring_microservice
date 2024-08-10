package org.rabin.customer.customer;

/*
 * @author : rabin
 */

public record CustomerResponse (
        String id,       // Unique identifier for the customer
        String firstname, // Customer's first name
        String lastname,  // Customer's last name
        String email,     // Customer's email address
        Address address   // Customer's address, represented by an Address object
){
}
