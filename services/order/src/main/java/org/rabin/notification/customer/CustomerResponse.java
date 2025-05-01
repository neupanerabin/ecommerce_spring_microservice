package org.rabin.notification.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
