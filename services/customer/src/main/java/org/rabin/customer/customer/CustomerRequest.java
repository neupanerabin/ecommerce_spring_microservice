package org.rabin.customer.customer;

/*
 * @author : rabin
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (
        String id,
        // Validates that the firstname field is not null
        @NotNull(message = "Customer firstname is required")
        String firstname,

        // Validates that the lastname field is not null
        @NotNull(message = "Customer lastname is required")
        String lastname,

        // Validates that the email field is not null and conforms to a valid email format
        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is not a valid email address")
        String email,
        // Address is optional, but can include validation within the Address class if needed
        Address address
){

}
