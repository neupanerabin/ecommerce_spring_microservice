package com.rabin.config_server.customer;

/*
 * @author : rabin
 */

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Enables the builder pattern for creating Customer instances
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@Document // Marks this class as a MongoDB document
public class Customer {

    @Id // Marks this field as the primary key in MongoDB
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address; // Association with Address class to store address details
}
