package org.rabin.notification.notification;


/*
 * @author : rabin
 */

import org.rabin.notification.payment.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail


) {
}
