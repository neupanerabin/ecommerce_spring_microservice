package com.rabin.config_server.customer;

/*
 * @author : rabin
 */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component // Marks this class as a Spring service
public class CustomerMapper {

    // Maps a CustomerRequest object to a Customer entity
    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null; // Returns null if the request is null
        }
        return Customer.builder() // Uses builder pattern to create a Customer object
                .id(request.id()) // Sets the ID
                .firstname(request.firstname()) // Sets the first name
                .lastname(request.lastname()) // Sets the last name
                .email(request.email()) // Sets the email
                .address(request.address()) // Sets the address
                .build();
    }

    // Maps a Customer entity to a CustomerResponse object
    public CustomerResponse fromCustomer(Customer customer) {
        if(customer == null){
            return null;
        }
        return new CustomerResponse(
                customer.getId(), // Gets the ID
                customer.getFirstname(), // Gets the first name
                customer.getLastname(), // Gets the last name
                customer.getEmail(), // Gets the email
                customer.getAddress() // Gets the address
        );
    }
}
