package org.rabin.customer.customer;

import lombok.*;
import org.springframework.validation.annotation.Validated;

/*
 * @author : rabin
 */

@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Enables the builder pattern for creating Address instances
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@Validated // Enables validation on this class
public class Address {
    private String street; // Street name
    private String houseNumber; // House number
    private String zipCode; // ZIP code

}
