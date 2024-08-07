package com.rabin.config_server.customer;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;


/*
 * @author : rabin
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;

}
