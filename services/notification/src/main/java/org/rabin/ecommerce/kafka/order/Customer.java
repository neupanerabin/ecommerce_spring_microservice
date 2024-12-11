package org.rabin.ecommerce.kafka.order;

/*
 * @author : rabin
 */
public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {


}
