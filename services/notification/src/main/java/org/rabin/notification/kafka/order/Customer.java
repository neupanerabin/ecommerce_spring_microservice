package org.rabin.notification.kafka.order;

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
