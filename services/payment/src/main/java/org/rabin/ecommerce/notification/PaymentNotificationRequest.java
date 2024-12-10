package org.rabin.ecommerce.notification;


/*
 * @author : rabin
 */

import org.rabin.ecommerce.payment.PaymentMethod;

public record PaymentNotificationRequest(
        String orderReference,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail


) {
}
