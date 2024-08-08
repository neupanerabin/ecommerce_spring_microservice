package com.rabin.config_server.customer;

/*
 * @author : rabin
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse (
        String id,       // Unique identifier for the customer
        String firstname, // Customer's first name
        String lastname,  // Customer's last name
        String email,     // Customer's email address
        Address address   // Customer's address, represented by an Address object
){
}
